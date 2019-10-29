
package acme.entities.coboBulletin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CoboBulletin extends DomainEntity {

	// Identifier

	private static final long	serialVersionUID	= 1L;

	// Atributes

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationDate;

	@NotBlank
	private String				author;

	@Positive
	@NotNull
	private Integer				salary;

	@NotBlank
	private String				location;

	@NotBlank
	private String				description;

}
