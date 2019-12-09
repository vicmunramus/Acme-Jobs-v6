
package acme.features.worker.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		boolean result = true;

		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "moment", "status", "statement", "skills", "qualifications");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("jobId", request.getModel().getInteger("jobId"));
		}
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		Application result = new Application();

		int jobId = request.getModel().getInteger("jobId");
		Job job = this.repository.findOneJobById(jobId);
		result.setJob(job);

		int workerId = request.getPrincipal().getActiveRoleId();
		Worker worker = this.repository.findOneWorkerById(workerId);
		result.setWorker(worker);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
