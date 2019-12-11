/*
 * AuthenticatedUserAccountUpdateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuthenticatedMessageThreadUpdateUsersService implements AbstractUpdateService<Authenticated, MessageThread> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	// AbstractUpdateService<Authenticated, UserAccount> interface ------------

	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "username");
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");

	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread result;

		int id = request.getModel().getInteger("messageThreadId");
		result = this.repository.findOneMessageThread(id);

		return result;
	}

	@Override
	public void validate(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String username = request.getModel().getString("username");
		UserAccount user = this.repository.findOneUserAccountdByUsername(username);

		if (!errors.hasErrors("username")) {
			Boolean existUser = user != null;
			errors.state(request, existUser, "username", "authenticated.existUser.error.not-exist");
		}
		if (!errors.hasErrors("username")) {
			if (request.getModel().getString("action") == "add") {
				int messageThreadId = request.getModel().getInteger("messageThreadId");
				Boolean unique = this.repository.existUserAccountInMessageThread(user.getId(), messageThreadId) == 0;
				errors.state(request, unique, "username", "authenticated.unique.error.already-exist");
			}
		}
	}

	@Override
	public void update(final Request<MessageThread> request, final MessageThread entity) {
		assert request != null;
		assert entity != null;

		String username = request.getModel().getString("username");
		UserAccount ua = this.repository.findOneUserAccountdByUsername(username);

		int messageThreadId = request.getModel().getInteger("messageThreadId");
		Collection<UserAccount> involvedUsers = this.repository.findManyUserAccountdByMessageThreadId(messageThreadId);

		switch (request.getModel().getString("action")) {
		case "add":
			involvedUsers.add(ua);
			break;
		case "delete":
			involvedUsers.remove(ua);
			break;
		}
		entity.setInvolvedUsers(involvedUsers);

		this.repository.save(entity);
	}

}
