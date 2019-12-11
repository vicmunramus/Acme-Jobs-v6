
package acme.features.authenticated.message;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.entities.messages.Message;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageCreateService implements AbstractCreateService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		boolean result = true;

		return result;
	}

	@Override
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags", "body", "messageThread.title", "creator.username");

	}

	@Override
	public Message instantiate(final Request<Message> request) {
		Message result = new Message();

		int userId = request.getPrincipal().getAccountId();
		UserAccount userAccount = this.repository.findOneUserAccountdById(userId);
		result.setCreator(userAccount);

		return result;
	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("messageThread.title")) {
			String msgThreadTitle = request.getModel().getString("messageThread.title");
			int messageThreadId = this.repository.findOneMessageThreadByTitle(msgThreadTitle).getId();
			Integer userId = request.getPrincipal().getAccountId();
			boolean existUser = this.repository.existUserAccountInMessageThread(userId, messageThreadId) > 0;

			errors.state(request, existUser, "messageThread.title", "authenticated.message.involved-user.error.not-involved");
		}
	}

	@Override
	public void create(final Request<Message> request, final Message entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		String msgThreadTitle = request.getModel().getString("messageThread.title");
		MessageThread messageThread = this.repository.findOneMessageThreadByTitle(msgThreadTitle);
		entity.setMessageThread(messageThread);

		this.repository.save(entity);

	}

}
