
package acme.entities.customisationParameters;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomisationParameters extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Spam:

	@NotBlank
	private String				spamListEn;

	@NotBlank
	private String				spamListEs;

	@Positive
	@DecimalMax(value = "1")
	private Float				spamThreshold;

	@NotNull
	private Integer				identifier;

}
