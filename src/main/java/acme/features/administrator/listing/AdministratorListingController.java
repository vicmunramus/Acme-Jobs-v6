
package acme.features.administrator.listing;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;
import acme.listing.Listing;

@Controller
@RequestMapping("/administrator/listing/")
public class AdministratorListingController extends AbstractController<Administrator, Listing> {

	@Autowired
	AdministratorListingShowService showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
