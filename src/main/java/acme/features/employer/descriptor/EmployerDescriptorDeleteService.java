
package acme.features.employer.descriptor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Status;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerDescriptorDeleteService implements AbstractDeleteService<Employer, Descriptor> {

	@Autowired
	EmployerDescriptorRepository repository;


	@Override
	public boolean authorise(final Request<Descriptor> request) {
		assert request != null;
		boolean result = true;

		//Assure this is the owner of the descriptor
		int descriptorId;
		Descriptor descriptor;
		Employer employer;
		Principal principal;

		descriptorId = request.getModel().getInteger("id");
		descriptor = this.repository.findOneDescriptorById(descriptorId);
		employer = descriptor.getJob().getEmployer();
		principal = request.getPrincipal();

		result = result && employer.getUserAccount().getId() == principal.getAccountId();

		//Assure the job is in draft

		result = result && descriptor.getJob().getStatus() == Status.DRAFT;

		return result;
	}

	@Override
	public void bind(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Descriptor> request, final Descriptor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
	}

	@Override
	public Descriptor findOne(final Request<Descriptor> request) {
		assert request != null;

		Descriptor result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneDescriptorById(id);

		return result;
	}

	@Override
	public void validate(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Descriptor> request, final Descriptor entity) {
		assert request != null;
		assert entity != null;

		Collection<Duty> duties;
		int descriptorId;
		descriptorId = request.getModel().getInteger("id");

		duties = this.repository.findManyDutiesByDescriptorId(descriptorId);
		if (duties != null) {
			for (Duty duty : duties) {
				this.repository.delete(duty);
			}
		}

		this.repository.delete(entity);
	}

}
