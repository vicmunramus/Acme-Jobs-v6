
package acme.features.anonymous.aguilarBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aguilarBulletins.AguilarBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousAguilarBulletinListService implements AbstractListService<Anonymous, AguilarBulletin> {

	//Internal state
	@Autowired
	AnonymousAguilarBulletinRepository repository;
	//AbstractListService interface


	@Override
	public boolean authorise(final Request<AguilarBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<AguilarBulletin> request, final AguilarBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "company", "vacancy", "requirement", "salary");
	}

	@Override
	public Collection<AguilarBulletin> findMany(final Request<AguilarBulletin> request) {
		assert request != null;
		Collection<AguilarBulletin> result;
		result = this.repository.findMany();
		return result;
	}

}
