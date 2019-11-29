
package acme.entities.jobs;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Duty extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				titleDuty;

	@NotBlank
	private String				descriptionDuty;

	@Range(min = 0, max = 100)
	private Integer				percentage;

}
