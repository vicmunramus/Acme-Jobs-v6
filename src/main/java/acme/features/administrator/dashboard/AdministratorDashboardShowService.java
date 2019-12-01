
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

		request.unbind(entity, model, "gridLabels", "dataInvestor", "dataCompany", "statusApplicationLabels", "statusJobLabels", "dataJob", "dataApplication", "numberAnnouncement", "numberCompanyRecords", "numberInvestorRecord", "minimunRewardOffer",
			"maximunRewardOffer", "averageRewardOffer", "minimunRewardRequest", "maximunRewardRequest", "averageRewardRequest", "stdRequest", "stdOffer", "avgNumberJobsPerEmployer", "avgNumberApplicationsPerEmployer", "avgNumberApplicationsPerWorker");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		//DO2:
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
		//D04:

		//Listing D02:
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

		//Listing D04:
		result.setAvgNumberJobsPerEmployer(this.repository.avgNumberJobsPerEmployer() != null ? this.repository.avgNumberJobsPerEmployer() : 0.);
		result.setAvgNumberApplicationsPerEmployer(this.repository.avgNumberApplicationsPerEmployer() != null ? this.repository.avgNumberApplicationsPerEmployer() : 0.);
		result.setAvgNumberApplicationsPerWorker(this.repository.avgNumberApplicationsPerWorker() != null ? this.repository.avgNumberApplicationsPerWorker() : 0.);

		//Tablero Sectores

		String[] iSector = this.repository.investorSector();
		String[] cSector = this.repository.companySector(iSector);
		String[] labels = iSector;
		labels = ArrayUtils.addAll(labels, cSector);

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

		String[] dataInvestor = this.repository.dataInvestor();

		dataInvestor = ArrayUtils.addAll(dataInvestor, new String[labels.length - dataInvestor.length]);

		result.setGridLabels(labels);

		result.setDataCompany(dataCompany);

		result.setDataInvestor(dataInvestor);

		//Tablero Status

		result.setStatusJobLabels(this.repository.jobStatus());

		result.setStatusApplicationLabels(this.repository.applicationStatus());

		result.setDataJob(this.repository.dataJob());

		result.setDataApplication(this.repository.dataApplication());

		return result;
	}

}
