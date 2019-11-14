
package acme.features.administrator.dashboard;

import org.apache.commons.lang3.ArrayUtils;
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

		request.unbind(entity, model, "gridLabels", "dataInvestor", "dataCompany");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		result = new Dashboard();

		String[] iSector = this.repository.investorSector();
		String[] cSector = this.repository.companySector();
		String[] labels = {};

		for (String element : iSector) {
			if (!ArrayUtils.contains(labels, element)) {
				labels = ArrayUtils.add(labels, element);
			}
		}

		for (String element : cSector) {
			if (!ArrayUtils.contains(labels, element)) {
				labels = ArrayUtils.add(labels, element);
			}
		}

		String[] tempDataCompany = this.repository.dataCompany();
		String[] dataCompany = new String[labels.length];

		for (String element : tempDataCompany) {
			String[] s = element.split(",");

			for (int i = 0; i < labels.length; i++) {
				if (labels[i].matches(s[0])) {
					dataCompany[i] = s[1];
				}
			}
		}

		String[] tempInvestorCompany = this.repository.dataInvestor();
		String[] dataInvestor = new String[labels.length];

		for (String element : tempInvestorCompany) {
			String[] s = element.split(",");

			for (int i = 0; i < labels.length; i++) {
				if (labels[i].matches(s[0])) {
					dataInvestor[i] = s[1];
				}
			}
		}

		result.setGridLabels(labels);

		for (int i = 0; i < dataCompany.length; i++) {
			if (dataCompany[i] == null) {
				dataCompany[i] = "0";
			}
		}

		result.setDataCompany(dataCompany);

		for (int i = 0; i < dataInvestor.length; i++) {
			if (dataInvestor[i] == null) {
				dataInvestor[i] = "0";
			}
		}
		result.setDataInvestor(dataInvestor);
		return result;
	}

}
