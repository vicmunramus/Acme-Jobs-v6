
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	//Internal state
	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberInvestorRecordPrimarySector", "numberInvestorRecordSecondarySector", "numberInvestorRecordServiceSector");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		result = new Dashboard();
		result.setNumberInvestorRecordPrimarySector(this.repository.findPrimarySectorInvestorRecord());
		result.setNumberInvestorRecordSecondarySector(this.repository.findSecondarySectorInvestorRecord());
		result.setNumberInvestorRecordServiceSector(this.repository.findServiceSectorInvestorRecord());
		return result;
	}

}
