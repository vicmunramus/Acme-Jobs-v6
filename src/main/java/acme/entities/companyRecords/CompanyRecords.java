
package acme.entities.companyRecords;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecords extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				companyName;

	@NotBlank
	private String				workSector;

	@NotBlank
	private String				ceoName;

	@NotBlank
	private String				activityDesc;

	@NotBlank
	@Pattern(regexp = "[w]{3}[.][a-zA-Z0-9-_.]{1,100}[.][a-z]{2,}$", flags = Flag.UNICODE_CASE)
	private String				webSite;

	@NotBlank
	@Pattern(regexp = "[+]+[1-9]{1,3}+[ (]+[0-9]{1,4}+[) ]+[0-9]{6,10}$", flags = Flag.UNICODE_CASE)
	private String				contactPhone;

	@NotBlank
	@Pattern(regexp = "[a-zA-Z0-9._-]{1,120}+@[a-zA-Z0-9]{1,50}+[.]+[a-zA-Z]{2,}$", flags = Flag.UNICODE_CASE)
	private String				contactEmail;

	private Boolean				incorporated;

	@Range(min = 0, max = 5)
	private Integer				rating;
}
