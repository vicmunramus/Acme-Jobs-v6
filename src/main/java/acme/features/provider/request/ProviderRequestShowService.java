
package acme.features.provider.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class ProviderRequestShowService implements AbstractShowService<Provider, acme.entities.requests.Request> {

	// Internal state

	@Autowired
	private ProviderRequestRepository repository;


	//Interface

	@Override
	public boolean authorise(final Request<acme.entities.requests.Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "createdAt", "deadline", "description", "reward", "ticker");
	}

	@Override
	public acme.entities.requests.Request findOne(final Request<acme.entities.requests.Request> request) {

		assert request != null;

		acme.entities.requests.Request result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
