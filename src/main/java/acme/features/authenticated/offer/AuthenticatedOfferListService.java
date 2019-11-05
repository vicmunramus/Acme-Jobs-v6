
package acme.features.authenticated.offer;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOfferListService implements AbstractListService<Authenticated, Offer> {

	// Internal state

	@Autowired
	AuthenticatedOfferRepository repository;


	// Interface

	@Override
	public boolean authorise(final Request<Offer> request) {

		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "minReward", "maxReward", "deadline");
	}

	@Override
	public Collection<Offer> findMany(final Request<Offer> request) {

		assert request != null;

		Collection<Offer> result;
		Date date = new Date(System.currentTimeMillis());

		result = this.repository.findMany(date);

		return result;
	}

}
