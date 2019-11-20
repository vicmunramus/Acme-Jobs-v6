
package acme.features.consumer.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
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

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
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

		Date dateNow = new Date(System.currentTimeMillis());
		boolean deadlineFuture, rangeReward, eurosMinReward, eurosMaxReward, positive, uniqueTicker, isAccepted;

		if (!errors.hasErrors("deadline")) {

			deadlineFuture = entity.getDeadline().after(dateNow);
			errors.state(request, deadlineFuture, "deadline", "consumer.offer.form.error.deadlineFuture");
		}

		if (!errors.hasErrors("minReward") && entity.getMinReward() != null && entity.getMaxReward() != null) {

			positive = entity.getMinReward().getAmount() >= 0;
			errors.state(request, positive, "minReward", "consumer.offer.form.error.minPositive");

			eurosMinReward = entity.getMinReward().getCurrency().equals("€") || entity.getMinReward().getCurrency().equals("EUR");
			errors.state(request, eurosMinReward, "minReward", "consumer.offer.form.error.minEuros");
		}

		if (!errors.hasErrors("maxReward") && entity.getMinReward() != null && entity.getMaxReward() != null) {

			rangeReward = entity.getMinReward().getAmount() <= entity.getMaxReward().getAmount();
			errors.state(request, rangeReward, "maxReward", "consumer.offer.form.error.rangeReward");

			eurosMaxReward = entity.getMaxReward().getCurrency().equals("€") || entity.getMaxReward().getCurrency().equals("EUR");
			errors.state(request, eurosMaxReward, "maxReward", "consumer.offer.form.error.maxEuros");

			positive = entity.getMaxReward().getAmount() >= 0;
			errors.state(request, positive, "maxReward", "consumer.offer.form.error.maxPositive");
		}

		if (!errors.hasErrors("ticker")) {

			uniqueTicker = this.repository.findOneOfferByTicker(entity.getTicker()) == null;
			errors.state(request, uniqueTicker, "ticker", "consumer.offer.form.error.uniqueTicker");
		}

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "consumer.offer.form.error.confirmation");
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {

		Date creationMoment;

		creationMoment = new Date(System.currentTimeMillis() - 1);

		entity.setCreationMoment(creationMoment);

		this.repository.save(entity);
	}

}
