
package acme.features.anonymous.quintelaBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.quintelaBulletin.QuintelaBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/quintela-bulletin/")
public class AnonymousQuintelaBulletinController extends AbstractController<Anonymous, QuintelaBulletin> {

	@Autowired
	private AnonymousQuintelaBulletinListService	listService;
	@Autowired
	private AnonymousQuintelaBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}
}
