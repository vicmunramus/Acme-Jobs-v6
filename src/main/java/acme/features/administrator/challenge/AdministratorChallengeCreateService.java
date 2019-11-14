
package acme.features.administrator.challenge;

import java.util.Date;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldGoal", "goldReward", "silverGoal", "silverReward", "bronzeGoal", "bronzeReward");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//DEADLINE
		if (!errors.hasErrors("deadline")) {
			boolean isAfter;
			isAfter = request.getModel().getDate("deadline").after(new Date(System.currentTimeMillis()));
			errors.state(request, isAfter, "deadline", "administrator.challenge.error.deadline-must-be-in-the-future");
		}

		//REWARDS
		if (!errors.hasErrors("bronzeReward")) {
			String bronzeReward = request.getModel().getString("bronzeReward");
			errors.state(request, this.inEuros(bronzeReward), "bronzeReward", "administrator.challenge.error.reward-must-be-in-euros");
		}

		if (!errors.hasErrors("silverReward")) {
			String silverReward = request.getModel().getString("silverReward");
			errors.state(request, this.inEuros(silverReward), "silverReward", "administrator.challenge.error.reward-must-be-in-euros");
		}

		if (!errors.hasErrors("goldReward")) {
			String goldReward = request.getModel().getString("goldReward");
			errors.state(request, this.inEuros(goldReward), "goldReward", "administrator.challenge.error.reward-must-be-in-euros");
		}
	}

	private boolean inEuros(final String reward) {
		String comma = ",";
		String point = ".";
		String currency;

		currency = reward.chars().mapToObj(c -> (char) c).filter(x -> !Character.isDigit(x) && !x.equals(comma.charAt(0)) && !x.equals(point.charAt(0)))
			.collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString)).trim();

		return currency.equals("€") || currency.equals("EUR");
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
