
package acme.features.employer.descriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Status;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerDescriptorUpdateService implements AbstractUpdateService<Employer, Descriptor> {

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

		if (request.isMethod(HttpMethod.POST)) {

			Integer descriptorId = request.getModel().getInteger("id");
			Descriptor descriptor = this.repository.findOneDescriptorById(descriptorId);
			Status status = descriptor.getJob().getStatus();

			request.getModel().setAttribute("jobStatus", status);
		}

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
	public void update(final Request<Descriptor> request, final Descriptor entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
