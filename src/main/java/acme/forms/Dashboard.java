
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	//Attributes
	Integer						numberInvestorRecordPrimarySector;
	Integer						numberInvestorRecordSecondarySector;
	Integer						numberInvestorRecordServiceSector;

}
