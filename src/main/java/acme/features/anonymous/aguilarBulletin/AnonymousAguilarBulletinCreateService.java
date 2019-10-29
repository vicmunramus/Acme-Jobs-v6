
package acme.features.anonymous.aguilarBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.aguilarBulletins.AguilarBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousAguilarBulletinCreateService implements AbstractCreateService<Anonymous, AguilarBulletin> {

	//Internal state
	@Autowired
	AnonymousAguilarBulletinRepository repository;


	@Override
	public boolean authorise(final Request<AguilarBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<AguilarBulletin> request, final AguilarBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AguilarBulletin> request, final AguilarBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "vacancy", "requirement", "salary");
	}

	@Override
	public AguilarBulletin instantiate(final Request<AguilarBulletin> request) {
		assert request != null;

		AguilarBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new AguilarBulletin();
		result.setCompany("Alvaro's company");
		result.setVacancy(2);
		result.setRequirement("Anything");
		result.setSalary(1000);
		result.setMoment(moment);
		return result;
	}

	@Override
	public void validate(final Request<AguilarBulletin> request, final AguilarBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<AguilarBulletin> request, final AguilarBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
