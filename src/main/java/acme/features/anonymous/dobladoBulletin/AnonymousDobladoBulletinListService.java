
package acme.features.anonymous.dobladoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dobladoBulletin.DobladoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousDobladoBulletinListService implements AbstractListService<Anonymous, DobladoBulletin> {

	@Autowired
	AnonymousDobladoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<DobladoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<DobladoBulletin> request, final DobladoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "name", "location", "degree", "text");

	}

	@Override
	public Collection<DobladoBulletin> findMany(final Request<DobladoBulletin> request) {
		assert request != null;

		Collection<DobladoBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
