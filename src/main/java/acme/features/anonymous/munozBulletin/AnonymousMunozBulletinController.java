
package acme.features.anonymous.munozBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.munozBulletins.MunozBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/munoz-bulletin")
public class AnonymousMunozBulletinController extends AbstractController<Anonymous, MunozBulletin> {

	@Autowired
	private AnonymousMunozBulletinListService	listService;

	@Autowired
	private AnonymousMunozBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
