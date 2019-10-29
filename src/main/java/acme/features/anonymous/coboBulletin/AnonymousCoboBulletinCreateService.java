
package acme.features.anonymous.coboBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.coboBulletin.CoboBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousCoboBulletinCreateService implements AbstractCreateService<Anonymous, CoboBulletin> {

	@Autowired
	AnonymousCoboBulletinRepository repository;


	@Override
	public boolean authorise(final Request<CoboBulletin> request) {

		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<CoboBulletin> request, final CoboBulletin entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<CoboBulletin> request, final CoboBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "salary", "location", "description");
	}

	@Override
	public CoboBulletin instantiate(final Request<CoboBulletin> request) {

		assert request != null;

		CoboBulletin result;

		Date creationDate;

		creationDate = new Date(System.currentTimeMillis() - 1);
		String author = "Bussiness";
		Integer salary = 25000;
		String location = "City";
		String description = "Job offer";

		result = new CoboBulletin();
		result.setCreationDate(creationDate);
		result.setAuthor(author);
		result.setSalary(salary);
		result.setLocation(location);
		result.setDescription(description);

		return result;
	}

	@Override
	public void validate(final Request<CoboBulletin> request, final CoboBulletin entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<CoboBulletin> request, final CoboBulletin entity) {

		assert request != null;
		assert entity != null;

		Date createDate;
		createDate = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(createDate);

		this.repository.save(entity);
	}

}
