
package acme.features.administrator.banner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.banners.Banner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/banner/")
public class AdministratorBannerController extends AbstractController<Administrator, Banner> {

	@Autowired
	private AdministratorBannerListService					listService;

	@Autowired
	private AdministratorBannerShowService					showService;

	@Autowired
	private AdministratorBannerCreateCommercialService		createCommercialService;

	@Autowired
	private AdministratorBannerCreateNonCommercialService	createNonCommercialService;

	@Autowired
	private AdministratorBannerUpdateCommercialService		updateCommercialService;

	@Autowired
	private AdministratorBannerUpdateNonCommercialService	updateNonCommercialService;

	@Autowired
	private AdministratorBannerDeleteService				deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);

		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.CREATE_COMMERCIAL, BasicCommand.CREATE, this.createCommercialService);

		super.addCustomCommand(CustomCommand.CREATE_NON_COMMERCIAL, BasicCommand.CREATE, this.createNonCommercialService);

		super.addCustomCommand(CustomCommand.UPDATE_COMMERCIAL, BasicCommand.UPDATE, this.updateCommercialService);

		super.addCustomCommand(CustomCommand.UPDATE_NON_COMMERCIAL, BasicCommand.UPDATE, this.updateNonCommercialService);

		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
