
package acme.entities.requests;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

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
	@NotBlank
	private String				reward;
	@NotBlank
	@Pattern(regexp = "R\\w\\w\\w\\w-\\d\\d\\d\\d\\d")
	private String				ticket;

}
