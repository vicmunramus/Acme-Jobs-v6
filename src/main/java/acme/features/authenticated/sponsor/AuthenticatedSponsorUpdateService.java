
package acme.features.authenticated.sponsor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.creditCards.CreditCard;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuthenticatedSponsorUpdateService implements AbstractUpdateService<Authenticated, Sponsor> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedSponsorRepository repository;


	@Override
	public boolean authorise(final Request<Sponsor> request) {
		// TODO Auto-generated method stub
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Sponsor> request, final Sponsor entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Sponsor> request, final Sponsor entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "organisationName");

		CreditCard cc = this.repository.findOneCreditCardBySponsorId(this.repository.findOneSponsorByUserAccountId(request.getPrincipal().getAccountId()).getId());
		if (request.isMethod(HttpMethod.GET) && cc != null) {
			model.setAttribute("creditCardNumber", cc.getCreditCardNumber());
			model.setAttribute("cardHolder", cc.getCardHolder());
			model.setAttribute("cvv", cc.getCvv());
			model.setAttribute("expirationDate", cc.getExpirationDate());
		}
	}

	@Override
	public Sponsor findOne(final Request<Sponsor> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Sponsor result;
		Principal principal;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		result = this.repository.findOneSponsorByUserAccountId(userAccountId);

		return result;
	}

	@Override
	public void validate(final Request<Sponsor> request, final Sponsor entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean creditCardNumberNotBlank, cardHolderNotBlank, cvvNotBlank, expirationDateNotBlank;

		if (!request.getModel().getString("creditCardNumber").isEmpty() || !request.getModel().getString("cardHolder").isEmpty() || !request.getModel().getString("cvv").isEmpty() || !request.getModel().getString("expirationDate").isEmpty()) {
			if (!errors.hasErrors("creditCardNumber")) {
				creditCardNumberNotBlank = request.getModel().getString("creditCardNumber") != "";
				if (!creditCardNumberNotBlank) {
					String errorMsg = request.getLocale().getDisplayLanguage().equals("English") ? "The credit card number can not be empty" : "El número de la tarjeta no puede estar vacío";
					errors.add("creditCardNumber", errorMsg);
				} else if (!this.isFake(request.getModel().getString("creditCardNumber"))) {
					String errorMsg = request.getLocale().getDisplayLanguage().equals("English") ? "The credit card number can not be fake" : "El número de la tarjeta no puede ser falso";
					errors.add("creditCardNumber", errorMsg);
				}
			}
			if (!errors.hasErrors("cardHolder")) {
				cardHolderNotBlank = request.getModel().getString("cardHolder") != "";
				if (!cardHolderNotBlank) {
					String errorMsg = request.getLocale().getDisplayLanguage().equals("English") ? "The card holder can not be empty" : "El propietario de la tarjeta no puede estar vacío";
					errors.add("cardHolder", errorMsg);
				}
			}
			if (!errors.hasErrors("cvv")) {
				cvvNotBlank = request.getModel().getString("cvv") != "";
				if (!cvvNotBlank) {
					String errorMsg = request.getLocale().getDisplayLanguage().equals("English") ? "The cvv can not be empty" : "El cvv no puede estar vacío";
					errors.add("cvv", errorMsg);
				}
			}
			if (!errors.hasErrors("expirationDate")) {
				expirationDateNotBlank = request.getModel().getString("expirationDate") != "";
				if (!expirationDateNotBlank) {
					String errorMsg = request.getLocale().getDisplayLanguage().equals("English") ? "The expiration date can not be empty" : "La fecha de expiración no puede estar vacía";
					errors.add("expirationDate", errorMsg);
				}
			}
		}
	}

	@Override
	public void update(final Request<Sponsor> request, final Sponsor entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		if (!request.getModel().getString("creditCardNumber").isEmpty() && !request.getModel().getString("cardHolder").isEmpty() && !request.getModel().getString("cvv").isEmpty() && !request.getModel().getString("expirationDate").isEmpty()) {
			CreditCard cc = new CreditCard();
			if (this.repository.findOneCreditCardBySponsorId(entity.getId()) == null) {
				cc.setSponsor(entity);
			} else {
				cc = this.repository.findOneCreditCardBySponsorId(entity.getId());
			}
			cc.setCreditCardNumber(request.getModel().getString("creditCardNumber"));
			cc.setCardHolder(request.getModel().getString("cardHolder"));
			cc.setCvv(request.getModel().getString("cvv"));
			cc.setExpirationDate(request.getModel().getString("expirationDate"));
			this.repository.save(cc);
		} else if (this.repository.findOneCreditCardBySponsorId(entity.getId()) != null && request.getModel().getString("creditCardNumber").isEmpty() && request.getModel().getString("cardHolder").isEmpty() && request.getModel().getString("cvv").isEmpty()
			&& request.getModel().getString("expirationDate").isEmpty()) {
			CreditCard cc = this.repository.findOneCreditCardBySponsorId(entity.getId());
			this.repository.delete(cc);
		}

		this.repository.save(entity);
	}
	@Override
	public void onSuccess(final Request<Sponsor> request, final Response<Sponsor> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}
	private boolean isFake(final String string) {
		boolean result = string.length() == 16;
		if (result) {
			int sum = 0;
			int aux = 0;
			char[] n = string.toCharArray();
			for (int i = 0; i < n.length - 1; i++) {
				if (i == 0 || i % 2 == 0) {
					aux = Character.getNumericValue(n[i]);
					aux = aux * 2;
					if (aux > 9) {
						aux = aux - 9;
					}
				} else {
					aux = Character.getNumericValue(n[i]);
				}
				sum += aux;
			}
			result = sum * 9 % 10 == Character.getNumericValue(n[n.length - 1]);
		}
		return result;
	}

}
