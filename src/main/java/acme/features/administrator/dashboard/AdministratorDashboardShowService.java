
package acme.features.administrator.dashboard;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
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

		request.unbind(entity, model, "gridLabels", "dataInvestor", "dataCompany", "numberAnnouncement", "numberCompanyRecords", "numberInvestorRecord", "minimunRewardOffer", "maximunRewardOffer", "averageRewardOffer", "minimunRewardRequest",
			"maximunRewardRequest", "averageRewardRequest", "stdRequest", "stdOffer");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		result = new Dashboard();
		Money maxOffer = new Money();
		Money minOffer = new Money();
		Money avgOffer = new Money();
		Money stdOffer = new Money();
		Money maxRequest = new Money();
		Money minRequest = new Money();
		Money avgRequest = new Money();
		Money stdRequest = new Money();

		//Listing
		result.setNumberAnnouncement(this.repository.countAllAnnouncement());
		result.setNumberCompanyRecords(this.repository.countAllCompanyRecord());
		result.setNumberInvestorRecord(this.repository.countAllInvestorRecord());
		maxOffer.setAmount(this.repository.getMaxOffer() != null ? this.repository.getMaxOffer() : 0.0);
		maxOffer.setCurrency("EUR");
		result.setMaximunRewardOffer(maxOffer);
		minOffer.setAmount(this.repository.getMinOffer() != null ? this.repository.getMinOffer() : 0.0);
		minOffer.setCurrency("EUR");
		result.setMinimunRewardOffer(minOffer);
		Double avg = ((this.repository.getMaxAvgOffer() != null ? this.repository.getMaxAvgOffer() : 0.0) + (this.repository.getMinAvgOffer() != null ? this.repository.getMinAvgOffer() : 0.0)) / 2;
		avgOffer.setAmount(avg);
		avgOffer.setCurrency("EUR");
		result.setAverageRewardOffer(avgOffer);
		maxRequest.setAmount(this.repository.getMaxRequest() != null ? this.repository.getMaxRequest() : 0.0);
		maxRequest.setCurrency("EUR");
		result.setMaximunRewardRequest(maxRequest);
		minRequest.setAmount(this.repository.getMinRequest() != null ? this.repository.getMinRequest() : 0.0);
		minRequest.setCurrency("EUR");
		result.setMinimunRewardRequest(minRequest);
		avgRequest.setAmount(this.repository.getAvgRequest() != null ? this.repository.getAvgRequest() : 0.0);
		avgRequest.setCurrency("EUR");
		result.setAverageRewardRequest(avgRequest);
		stdRequest.setAmount(this.repository.getStdRequest() != null ? this.repository.getStdRequest() : 0.0);
		stdRequest.setCurrency("EUR");
		result.setStdRequest(stdRequest);
		Double stdOff = ((this.repository.getStdMaxOffer() != null ? this.repository.getStdMaxOffer() : 0.0) + (this.repository.getStdMinOffer() != null ? this.repository.getStdMinOffer() : 0.0)) / 2;
		stdOffer.setAmount(stdOff);
		stdOffer.setCurrency("EUR");
		result.setStdOffer(stdOffer);

		//Tablero

		String[] iSector = this.repository.investorSector();
		String[] cSector = this.repository.companySector();
		String[] labels = iSector;

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
