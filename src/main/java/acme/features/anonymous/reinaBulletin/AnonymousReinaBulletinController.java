
package acme.features.anonymous.reinaBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.reinaBulletin.ReinaBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/reina-bulletin/")
public class AnonymousReinaBulletinController extends AbstractController<Anonymous, ReinaBulletin> {

	@Autowired
	private AnonymousReinaBulletinListService	listService;

	@Autowired
	private AnonymousReinaBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
