
package acme.features.anonymous.dobladoBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.dobladoBulletin.DobladoBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/doblado-bulletin")
public class AnonymousDobladoBulletinController extends AbstractController<Anonymous, DobladoBulletin> {

	@Autowired
	private AnonymousDobladoBulletinListService		listService;

	@Autowired
	private AnonymousDobladoBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
