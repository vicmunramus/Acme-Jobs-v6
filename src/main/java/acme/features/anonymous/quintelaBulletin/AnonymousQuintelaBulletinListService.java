
package acme.features.anonymous.quintelaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quintelaBulletin.QuintelaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousQuintelaBulletinListService implements AbstractListService<Anonymous, QuintelaBulletin> {

	@Autowired
	AnonymousQuintelaBulletinRepository repository;


	@Override
	public Collection<QuintelaBulletin> findMany(final Request<QuintelaBulletin> request) {
		assert request != null;
		Collection<QuintelaBulletin> result;

		result = this.repository.findMany();
		return result;
	}
	@Override
	public void unbind(final Request<QuintelaBulletin> request, final QuintelaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "text", "author", "priority", "deadlineDate", "createdAt");
	}
	@Override
	public boolean authorise(final Request<QuintelaBulletin> request) {
		assert request != null;
		return true;
	}
}
