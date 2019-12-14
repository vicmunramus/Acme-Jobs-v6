
package acme.features.administrator.banner;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.banners.Commercial;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorBannerCreateCommercialService implements AbstractCreateService<Administrator, Banner> {

	@Autowired
	AdministratorBannerRepository repository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target", "creditCardNumber", "cardHolder", "cvv", "expirationDate");
	}

	@Override
	public Banner instantiate(final Request<Banner> request) {
		return new Commercial();
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("expirationDate")) {
			String[] expirationDate = ((Commercial) entity).getExpirationDate().split("/");
			Integer actualYear = Calendar.getInstance().get(Calendar.YEAR);
			String expirationYear;

			//Suponiendo caducidad de 4 años
			if (actualYear % 100 >= 96 && actualYear % 100 <= 99) {
				expirationYear = Integer.toString((actualYear + 100) / 100) + expirationDate[1];
			} else {
				expirationYear = Integer.toString(actualYear / 100) + expirationDate[1];
			}

			Date expDate = Date.valueOf(expirationYear + "-" + expirationDate[0] + "-01");
			Calendar expCal = Calendar.getInstance();
			expCal.setTime(expDate);
			expCal.add(Calendar.MONTH, 1);

			Calendar currentCal = Calendar.getInstance();

			boolean isAfter = currentCal.before(expCal);
			errors.state(request, isAfter, "expirationDate", "administrator.banner.error.the-card-has-expired");
		}
	}

	@Override
	public void create(final Request<Banner> request, final Banner entity) {
		assert request != null;

		this.repository.save(entity);
	}
}
