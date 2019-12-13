
package acme.features.authenticated.userAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedUserAccountShowService implements AbstractShowService<Authenticated, UserAccount> {

	// Internal state

	@Autowired
	private AuthenticatedUserAccountRepository repository;


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		boolean result = true;

		//		Integer messageThreadId = request.getModel().getInteger("id");
		//		Integer userId = request.getPrincipal().getAccountId();
		//
		//		result = this.repository.existAuthenticatedByMessageThreadId(userId, messageThreadId) > 0;

		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");
	}

	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		UserAccount result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserAccountById(id);

		return result;
	}

	//Interface

}
