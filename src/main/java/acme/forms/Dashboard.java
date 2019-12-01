
package acme.forms;

import java.io.Serializable;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	// D02 Attributes:
	String[]					gridLabels;
	String[]					dataInvestor;
	String[]					dataCompany;
	Integer						numberAnnouncement;
	Integer						numberCompanyRecords;
	Integer						numberInvestorRecord;
	Money						minimunRewardOffer;
	Money						maximunRewardOffer;
	Money						averageRewardOffer;
	Money						minimunRewardRequest;
	Money						maximunRewardRequest;
	Money						averageRewardRequest;
	Money						stdRequest;
	Money						stdOffer;

	// D04 Attributes:
	Double						avgNumberJobsPerEmployer;
	Double						avgNumberApplicationsPerEmployer;
	Double						avgNumberApplicationsPerWorker;
	String[]					statusApplicationLabels;
	String[]					statusJobLabels;
	String[]					dataJob;
	String[]					dataApplication;

}
