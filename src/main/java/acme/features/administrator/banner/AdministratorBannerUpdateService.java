
package acme.features.administrator.banner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.banners.Commercial;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorBannerUpdateService implements AbstractUpdateService<Administrator, Banner> {

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

		if (entity instanceof Commercial) {
			request.unbind(entity, model, "picture", "slogan", "target", "creditCardNumber", "cardHolder", "cvv", "expirationDate");
		} else {
			request.unbind(entity, model, "picture", "slogan", "target", "jingle");
		}
	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;
		Banner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity instanceof Commercial) {
			if (!errors.hasErrors("expirationDate")) {
				String[] expirationDate = ((Commercial) entity).getExpirationDate().split("/");
				String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) / 100) + expirationDate[1];

				boolean isAfter = true;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				try {
					Date expDate = sdf.parse(year + "-" + expirationDate[0] + "-01 00:00:00.000");
					isAfter = expDate.after(Calendar.getInstance().getTime());
					errors.state(request, isAfter, "expirationDate", "administrator.banner.error.expiration-date-must-be-in-the-future");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(final Request<Banner> request, final Banner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
