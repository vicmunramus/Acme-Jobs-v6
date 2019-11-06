
package acme.features.administrator.listing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;
import acme.listing.Listing;

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

		List<Double> std = this.repository.allRequests();
		Double resRequest = 0.0;
		for (int i = 0; i < std.size(); i++) {
			Double aux = (std.get(i) - this.repository.getAvgRequest()) * (std.get(i) - this.repository.getAvgRequest());
			resRequest += aux;
		}
		result.setStdRequest(Math.sqrt(resRequest / std.size()));

		List<Double> max = this.repository.allMaxOffers();
		List<Double> min = this.repository.allMinOffers();
		List<Double> middle = new ArrayList<>();
		for (int i = 0; i < max.size(); i++) {
			Double aux = (max.get(i) + min.get(i)) / 2;
			middle.add(aux);
		}
		Double resOffer = 0.0;
		for (int i = 0; i < middle.size(); i++) {
			Double aux = (middle.get(i) - avg) * (middle.get(i) - avg);
			resOffer += aux;
		}
		result.setStdOffer(Math.sqrt(resOffer / middle.size()));
		return result;
	}

}
