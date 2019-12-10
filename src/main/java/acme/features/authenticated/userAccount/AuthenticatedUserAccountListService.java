
package acme.features.authenticated.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedUserAccountListService implements AbstractListService<Authenticated, UserAccount> {

	@Autowired
	AuthenticatedUserAccountRepository repository;


	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;
		int id = request.getModel().getInteger("messageThreadId");
		result = this.repository.findManyUserAccountByMessageThreadId(id);
		//result = this.repository.findManyMessageThreads();

		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "id", "username");
	}
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		return true;
	}
}
