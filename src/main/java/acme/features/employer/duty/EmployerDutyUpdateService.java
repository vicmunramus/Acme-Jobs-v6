
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerDutyUpdateService implements AbstractUpdateService<Employer, Duty> {

	@Autowired
	EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		boolean result = true;

		//Assure this is the owner of the duty
		int dutyId;
		Duty duty;
		Employer employer;
		Principal principal;

		dutyId = request.getModel().getInteger("id");
		duty = this.repository.findOneDutyById(dutyId);
		employer = duty.getDescriptor().getJob().getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "titleDuty", "descriptionDuty", "percentage", "descriptor");
	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneDutyById(id);

		return result;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Integer allPercentages = 0;
		Collection<Duty> allDuties;
		boolean notMore100;

		// percentages not greater than 100%
		if (!errors.hasErrors("percentage")) {

			allDuties = this.repository.findManyDutiesByDescriptorId(entity.getDescriptor().getId());
			notMore100 = true;

			if (allDuties != null) {
				for (Duty d : allDuties) {
					allPercentages += d.getPercentage();
				}
			}
			notMore100 = allPercentages + entity.getPercentage() <= 100;
			errors.state(request, notMore100, "percentage", "employer.job.form.error.percentages-more-100");
		}
	}

	@Override
	public void update(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
