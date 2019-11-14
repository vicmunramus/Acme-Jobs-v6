
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
			boolean euroBronze;
			euroBronze = bronzeReward.contains("€") || bronzeReward.contains("EUR");
			errors.state(request, euroBronze, "bronzeReward", "administrator.challenge.error.reward-must-be-in-euros");
			errors.state(request, this.positiveAmount(bronzeReward), "bronzeReward", "administrator.challenge.error.reward-must-be-positive");
		}

		if (!errors.hasErrors("silverReward")) {
			String silverReward = request.getModel().getString("silverReward");
			boolean euroSilver;
			euroSilver = silverReward.contains("€") || silverReward.contains("EUR");
			errors.state(request, euroSilver, "silverReward", "administrator.challenge.error.reward-must-be-in-euros");
			errors.state(request, this.positiveAmount(silverReward), "silverReward", "administrator.challenge.error.reward-must-be-positive");
		}

		if (!errors.hasErrors("goldReward")) {
			String goldReward = request.getModel().getString("goldReward");
			boolean euroGold;
			euroGold = goldReward.contains("€") || goldReward.contains("EUR");
			errors.state(request, euroGold, "goldReward", "administrator.challenge.error.reward-must-be-in-euros");
			errors.state(request, this.positiveAmount(goldReward), "goldReward", "administrator.challenge.error.reward-must-be-positive");
		}
	}

	private boolean positiveAmount(final String reward) {
		boolean positiveAmount;
		String amount;
		String currency;
		String comma = ",";
		String point = ".";

		currency = reward.chars().mapToObj(c -> (char) c).filter(x -> !Character.isDigit(x) && !x.equals(comma.charAt(0)) && !x.equals(point.charAt(0)))
			.collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));

		if (Character.isDigit(reward.charAt(0))) {
			amount = reward.substring(0, reward.indexOf(currency.charAt(0)));
		} else {
			amount = reward.substring(reward.indexOf(currency.charAt(currency.length() - 1)) + 1, reward.length());
		}
		if (amount.contains(",") || amount.contains(".")) {
			if (amount.length() - amount.indexOf(",") <= 3 || amount.length() - amount.indexOf(".") > 3) {
				positiveAmount = Double.parseDouble(amount.replace(".", "").replace(",", ".")) > 0.0;
			} else {
				positiveAmount = Double.parseDouble(amount.replace(",", "")) > 0.0;
			}
		} else {
			positiveAmount = Double.parseDouble(amount) > 0.0;
		}

		return positiveAmount;
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
