
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, acme.entities.requests.Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public void bind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "createdAt");
	}
	@Override
	public void unbind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "createdAt", "deadline", "description", "reward", "ticker");
	}
	@Override
	public boolean authorise(final Request<acme.entities.requests.Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public acme.entities.requests.Request instantiate(final Request<acme.entities.requests.Request> request) {
		acme.entities.requests.Request result;
		result = new acme.entities.requests.Request();
		return result;
	}

	@Override
	public void validate(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Date currentTime = new Date(System.currentTimeMillis());
		Boolean cond = entity.getDeadline().after(currentTime);

		errors.state(request, cond, "deadline", "authenticated.provider.deadline.error");

	}

	@Override
	public void create(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreatedAt(moment);
		this.repository.save(entity);
	}
}
