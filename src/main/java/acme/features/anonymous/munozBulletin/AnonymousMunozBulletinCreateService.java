
package acme.features.anonymous.munozBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.munozBulletins.MunozBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousMunozBulletinCreateService implements AbstractCreateService<Anonymous, MunozBulletin> {

	@Autowired
	AnonymousMunozBulletinRepository repository;


	@Override
	public boolean authorise(final Request<MunozBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<MunozBulletin> request, final MunozBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<MunozBulletin> request, final MunozBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "groupName", "managerName", "size");
	}

	@Override
	public MunozBulletin instantiate(final Request<MunozBulletin> request) {
		assert request != null;

		MunozBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new MunozBulletin();
		result.setGroupName("Group Z");
		result.setManagerName("Tim Sweeney");
		result.setSize(1);
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<MunozBulletin> request, final MunozBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<MunozBulletin> request, final MunozBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
