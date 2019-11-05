
package acme.entities.quintelaBulletin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class QuintelaBulletin extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;
	@NotBlank
	private String				text;
	@NotBlank
	private String				author;
	@NotNull
	private Integer				priority;
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadlineDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				createdAt;

}
