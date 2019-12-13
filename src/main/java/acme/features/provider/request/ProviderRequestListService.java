
package acme.features.provider.request;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ProviderRequestListService implements AbstractListService<Provider, acme.entities.requests.Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public Collection<acme.entities.requests.Request> findMany(final Request<acme.entities.requests.Request> request) {
		assert request != null;

		Collection<acme.entities.requests.Request> result;

		Date d = Calendar.getInstance().getTime();

		result = this.repository.findManyAll(d);

		return result;
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
}
