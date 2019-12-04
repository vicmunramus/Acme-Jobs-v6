
package acme.features.authenticated.messageThread;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	// Internal state

	@Autowired
	private AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;
		boolean result;

		Integer messageThreadId = request.getModel().getInteger("id");
		MessageThread messageThread = this.repository.findOneMessageThread(messageThreadId);
		Integer creatorId = messageThread.getCreator().getId();
		Integer userId = request.getPrincipal().getActiveRoleId();

		result = this.repository.existAuthenticatedByMessageThreadId(messageThreadId, userId) > 0;
		result = result || creatorId == userId;
		return result;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "id", "title", "moment", "creator.userAccount.username", "user");
	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		// TODO Auto-generated method stub
		MessageThread result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneMessageThread(id);
		//result = this.repository.findManyMessageThreads();

		String[] vacio = new String[result.getInvolvedUsers().size()];
		for (UserAccount u : result.getInvolvedUsers()) {
			ArrayUtils.add(vacio, u.getUsername());
		}
		result.setUser(vacio);

		return result;
	}

	//Interface

}
