
package acme.features.anonymous.coboBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.coboBulletin.CoboBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousCoboBulletinListService implements AbstractListService<Anonymous, CoboBulletin> {

	@Autowired
	AnonymousCoboBulletinRepository repository;


	@Override
	public boolean authorise(final Request<CoboBulletin> request) {

		assert request != null;
		return true;
	}

	@Override
	public Collection<CoboBulletin> findMany(final Request<CoboBulletin> request) {

		assert request != null;

		Collection<CoboBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<CoboBulletin> request, final CoboBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationDate", "author", "salary", "location", "description");
	}

}
