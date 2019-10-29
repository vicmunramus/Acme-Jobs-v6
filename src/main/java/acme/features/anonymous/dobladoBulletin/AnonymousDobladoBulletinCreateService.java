
package acme.features.anonymous.dobladoBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dobladoBulletin.DobladoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousDobladoBulletinCreateService implements AbstractCreateService<Anonymous, DobladoBulletin> {

	@Autowired
	AnonymousDobladoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<DobladoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<DobladoBulletin> request, final DobladoBulletin entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<DobladoBulletin> request, final DobladoBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "location", "degree", "text");

	}

	@Override
	public DobladoBulletin instantiate(final Request<DobladoBulletin> request) {
		assert request != null;

		DobladoBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new DobladoBulletin();
		result.setMoment(moment);
		result.setName("Enrique Reina Gutierrez");
		result.setLocation("Madrid");
		result.setDegree("Magisterio");
		result.setText("Madrid la ciudad de las oportunidades");

		return result;
	}

	@Override
	public void validate(final Request<DobladoBulletin> request, final DobladoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<DobladoBulletin> request, final DobladoBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
