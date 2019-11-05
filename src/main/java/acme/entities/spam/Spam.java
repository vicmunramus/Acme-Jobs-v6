
package acme.entities.spam;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				wordEn;

	@NotBlank
	private String				wordEs;

	@Positive
	@DecimalMax(value = "2")
	private Float				threshold			= 0.01f;

}
