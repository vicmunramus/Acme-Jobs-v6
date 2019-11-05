
package acme.entities.requests;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Request extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;
	@NotBlank
	private String				description;
	@NotNull
	@Valid
	private Money				reward;
	@NotBlank
	@Pattern(regexp = "^R[A-Z]{4}-\\d{5}$")
	private String				ticket;

}
