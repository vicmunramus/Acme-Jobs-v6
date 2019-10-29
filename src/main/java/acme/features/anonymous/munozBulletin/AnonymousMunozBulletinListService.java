
package acme.features.anonymous.munozBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.munozBulletins.MunozBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousMunozBulletinListService implements AbstractListService<Anonymous, MunozBulletin> {

	@Autowired
	AnonymousMunozBulletinRepository repository;


	@Override
	public boolean authorise(final Request<MunozBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<MunozBulletin> request, final MunozBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "groupName", "managerName", "size");
	}

	@Override
	public Collection<MunozBulletin> findMany(final Request<MunozBulletin> request) {
		assert request != null;

		Collection<MunozBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
