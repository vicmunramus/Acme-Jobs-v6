
package acme.features.anonymous.reinaBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.reinaBulletin.ReinaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousReinaBulletinCreateService implements AbstractCreateService<Anonymous, ReinaBulletin> {

	@Autowired
	AnonymousReinaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<ReinaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ReinaBulletin> request, final ReinaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<ReinaBulletin> request, final ReinaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "age", "title", "text");

	}

	@Override
	public ReinaBulletin instantiate(final Request<ReinaBulletin> request) {
		assert request != null;

		ReinaBulletin result;

		Date createDate;

		createDate = new Date(System.currentTimeMillis() - 1);
		String author = "Quentin Tarantino";
		Integer age = 45;
		String title = "Quentin Tarantino 04";
		String text = "Esto es un ejemplo. Pon aqui lo que quieres decir.";

		result = new ReinaBulletin();
		result.setCreateDate(createDate);
		result.setAuthor(author);
		result.setAge(age);
		result.setTitle(title);
		result.setText(text);

		return result;
	}

	@Override
	public void validate(final Request<ReinaBulletin> request, final ReinaBulletin entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ReinaBulletin> request, final ReinaBulletin entity) {
		assert request != null;
		assert entity != null;

		Date createDate;
		createDate = new Date(System.currentTimeMillis() - 1);
		entity.setCreateDate(createDate);

		this.repository.save(entity);

	}

}
