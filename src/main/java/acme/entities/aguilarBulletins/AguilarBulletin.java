
package acme.entities.aguilarBulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AguilarBulletin extends DomainEntity {

	//Serialisation identifer
	private static final long	serialVersionUID	= 1L;
	//Attributes
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
	@NotBlank
	private String				company;
	@NotNull
	@Range(min = 1)
	private Integer				vacancy;
	@NotBlank
	private String				requirement;
	@Positive
	@NotNull
	private int					salary;

}
