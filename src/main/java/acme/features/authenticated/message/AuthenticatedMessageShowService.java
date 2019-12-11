
package acme.features.authenticated.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Message> {

	// Internal state

	@Autowired
	private AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags", "body", "messageThread.title", "creator.username");
	}

	@Override
	public Message findOne(final Request<Message> request) {
		// TODO Auto-generated method stub
		Message result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneMessageById(id);
		//result = this.repository.findManyMessageThreads();

		return result;
	}

	//Interface

}
