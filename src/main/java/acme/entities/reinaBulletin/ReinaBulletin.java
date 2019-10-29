
package acme.entities.reinaBulletin;

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
public class ReinaBulletin extends DomainEntity {

	//identifier
	private static final long	serialVersionUID	= 1L;

	//ReinaBulletin class attributes

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				createDate;

	@NotBlank
	private String				author;

	@NotNull
	@Positive
	private Integer				age;

	@NotBlank
	private String				title;

	@NotBlank
	private String				text;

}
