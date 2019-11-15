
package acme.features.administrator.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Listing;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorListingShowService implements AbstractShowService<Administrator, Listing> {

	@Autowired
	AdministratorListingRepository repository;


	@Override
	public boolean authorise(final Request<Listing> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Listing> request, final Listing entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberAnnouncement", "numberCompanyRecords", "numberInvestorRecord", "minimunRewardOffer", "maximunRewardOffer", "averageRewardOffer", "minimunRewardRequest", "maximunRewardRequest", "averageRewardRequest",
			"stdRequest", "stdOffer");
	}

	@Override
	public Listing findOne(final Request<Listing> request) {
		// TODO Auto-generated method stub
		assert request != null;
		Listing result;
		result = new Listing();
		result.setNumberAnnouncement(this.repository.countAllAnnouncement());
		result.setNumberCompanyRecords(this.repository.countAllCompanyRecord());
		result.setNumberInvestorRecord(this.repository.countAllInvestorRecord());
		result.setMaximunRewardOffer(this.repository.getMaxOffer());
		result.setMinimunRewardOffer(this.repository.getMinOffer());
		Double avg = (this.repository.getMaxAvgOffer() + this.repository.getMinAvgOffer()) / 2;
		result.setAverageRewardOffer(avg);
		result.setMaximunRewardRequest(this.repository.getMaxRequest());
		result.setMinimunRewardRequest(this.repository.getMinRequest());
		result.setAverageRewardRequest(this.repository.getAvgRequest());
		result.setStdRequest(this.repository.getStdRequest());
		Double stdOffer = (this.repository.getStdMaxOffer() + this.repository.getStdMinOffer()) / 2;
		result.setStdOffer(stdOffer);
		return result;
	}

}
