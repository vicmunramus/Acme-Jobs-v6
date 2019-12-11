
package acme.features.employer.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.jobs.Status;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "salary", "moreInfo", "status", "employer");
	}

	@Override
	public Job instantiate(final Request<Job> request) {
		Job result;
		result = new Job();
		Employer employer;
		employer = new Employer();

		int idEmployer = request.getPrincipal().getActiveRoleId();
		employer = this.repository.findOneEmployerById(idEmployer);

		result.setEmployer(employer);
		result.setStatus(Status.DRAFT);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAfter, uniqueReference, inEuros, positive;

		//DEADLINE
		if (!errors.hasErrors("deadline")) {
			isAfter = entity.getDeadline().after(new Date(System.currentTimeMillis()));
			errors.state(request, isAfter, "deadline", "employer.job.error.deadline-must-be-in-the-future");
		}
		//Reference
		if (!errors.hasErrors("reference")) {
			uniqueReference = this.repository.findOneJobByReference(entity.getReference()) == null;
			errors.state(request, uniqueReference, "reference", "employer.job.form.error.uniqueReference");
		}
		//Salary
		if (!errors.hasErrors("salary")) {

			inEuros = entity.getSalary().getCurrency().equals("€") || entity.getSalary().getCurrency().equals("EUR");
			errors.state(request, inEuros, "salary", "employer.job.form.error.salary-in-euros");

			positive = entity.getSalary().getAmount() >= 0.;
			errors.state(request, positive, "salary", "employer.job.form.error.salary-not-positive");
		}
	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
