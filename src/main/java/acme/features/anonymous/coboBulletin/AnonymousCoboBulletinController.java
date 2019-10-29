
package acme.features.anonymous.coboBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.coboBulletin.CoboBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/cobo-bulletin/")
public class AnonymousCoboBulletinController extends AbstractController<Anonymous, CoboBulletin> {

	@Autowired
	private AnonymousCoboBulletinListService	listService;

	@Autowired
	private AnonymousCoboBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
