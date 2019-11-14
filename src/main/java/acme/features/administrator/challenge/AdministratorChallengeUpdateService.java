
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

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
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

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

		if (Character.isDigit(reward.charAt(0))) {
			amount = reward.substring(0, reward.indexOf(" "));
		} else {
			amount = reward.substring(reward.indexOf(" ") + 1, reward.length());
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
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
