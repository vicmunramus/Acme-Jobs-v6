
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Listing implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						numberAnnouncement;
	Integer						numberCompanyRecords;
	Integer						numberInvestorRecord;
	Double						minimunRewardOffer;
	Double						maximunRewardOffer;
	Double						averageRewardOffer;
	Double						minimunRewardRequest;
	Double						maximunRewardRequest;
	Double						averageRewardRequest;
	Double						stdRequest;
	Double						stdOffer;
}
