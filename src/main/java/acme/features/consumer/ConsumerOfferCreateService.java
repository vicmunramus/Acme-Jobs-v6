
package acme.features.consumer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return false;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "deadline", "minReward", "maxReward", "ticker");
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {

		Offer result;

		result = new Offer();

		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		//Deadline en el futuro:
		Date now = new Date(System.currentTimeMillis());
		assert entity.getDeadline().after(now);

		//Money positive and in euros:
		Money minReward = entity.getMinReward();
		Money maxReward = entity.getMaxReward();

		assert minReward.getAmount() >= 0.0;
		assert maxReward.getAmount() >= 0.0;
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {

		Date creationMoment;

		creationMoment = new Date(System.currentTimeMillis() - 1);

		entity.setCreationMoment(creationMoment);

		this.repository.save(entity);
	}

}
