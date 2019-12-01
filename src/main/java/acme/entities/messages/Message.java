
package acme.entities.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.messageThreads.MessageThread;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "title")
})
public class Message extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
	//Relationships
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private MessageThread		messageThread;

}
