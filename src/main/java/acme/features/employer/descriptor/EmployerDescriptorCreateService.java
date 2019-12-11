
package acme.features.employer.descriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerDescriptorCreateService implements AbstractCreateService<Employer, Descriptor> {

	@Autowired
	EmployerDescriptorRepository repository;


	@Override
	public boolean authorise(final Request<Descriptor> request) {
		assert request != null;
		boolean result = true;

		//Assure this is the owner of the job
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

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

		request.unbind(entity, model, "description", "job");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("jobId", request.getModel().getInteger("jobId"));
		}

	}

	@Override
	public Descriptor instantiate(final Request<Descriptor> request) {

		Descriptor result;

		result = new Descriptor();
		Job job;

		int jobId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(jobId);

		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// No descriptor already created
		int jobId = request.getModel().getInteger("jobId");

		if (!errors.hasErrors("description")) {
			boolean noDescriptor;
			noDescriptor = this.repository.findOneDescriptorByJobId(jobId) == null;
			errors.state(request, noDescriptor, "description", "employer.descriptor.error.descriptor-exists");
		}
	}

	@Override
	public void create(final Request<Descriptor> request, final Descriptor entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
