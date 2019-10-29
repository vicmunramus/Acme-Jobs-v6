
package acme.features.anonymous.reinaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.reinaBulletin.ReinaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousReinaBulletinListService implements AbstractListService<Anonymous, ReinaBulletin> {

	@Autowired
	AnonymousReinaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<ReinaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ReinaBulletin> request, final ReinaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "createDate", "author", "age", "title", "text");
	}

	@Override
	public Collection<ReinaBulletin> findMany(final Request<ReinaBulletin> request) {
		assert request != null;

		Collection<ReinaBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
