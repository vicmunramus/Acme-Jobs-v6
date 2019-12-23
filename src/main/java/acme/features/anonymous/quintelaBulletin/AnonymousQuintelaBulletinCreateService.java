
package acme.features.anonymous.quintelaBulletin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quintelaBulletin.QuintelaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousQuintelaBulletinCreateService implements AbstractCreateService<Anonymous, QuintelaBulletin> {

	@Autowired
	AnonymousQuintelaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<QuintelaBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<QuintelaBulletin> request, final QuintelaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<QuintelaBulletin> request, final QuintelaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "text", "author", "priority", "deadlineDate", "createdAt");
	}

	@Override
	public QuintelaBulletin instantiate(final Request<QuintelaBulletin> request) {

		assert request != null;
		QuintelaBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new QuintelaBulletin();
		result.setTitle("Prueba02");
		result.setText("Esta es otra tarea de prueba");
		result.setAuthor("Prueba02");

		Date deadlineDate = null;

		try {
			deadlineDate = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse("2020/10/25 11:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setDeadlineDate(deadlineDate);

		result.setPriority(4);
		result.setCreatedAt(moment);
		return result;
	}

	@Override
	public void validate(final Request<QuintelaBulletin> request, final QuintelaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAfter;

		//Deadline
		if (!errors.hasErrors("deadlineDate")) {
			isAfter = entity.getDeadlineDate().after(new Date(System.currentTimeMillis()));
			errors.state(request, isAfter, "deadlineDate", "anonymous.quintelaBulletin.error.create.deadline");
		}

	}

	@Override
	public void create(final Request<QuintelaBulletin> request, final QuintelaBulletin entity) {
		assert request != null;
		assert entity != null;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreatedAt(moment);
		this.repository.save(entity);

	}

}
