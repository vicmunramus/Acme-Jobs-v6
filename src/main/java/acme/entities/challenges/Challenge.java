
package acme.entities.challenges;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldGoal;

	@NotBlank
	private String				goldReward;

	@NotBlank
	private String				silverGoal;

	@NotBlank
	private String				silverReward;

	@NotBlank
	private String				bronzeGoal;

	@NotBlank
	private String				bronzeReward;


	@Transient
	public String getGoldPair() {
		StringBuilder result;

		result = new StringBuilder();
		result.append(this.goldGoal);
		result.append(" \u2192 ");
		result.append(this.goldReward);

		return result.toString();
	}

	@Transient
	public String getSilverPair() {
		StringBuilder result;

		result = new StringBuilder();
		result.append(this.silverGoal);
		result.append(" \u2192 ");
		result.append(this.silverReward);

		return result.toString();
	}

	@Transient
	public String getBronzePair() {
		StringBuilder result;

		result = new StringBuilder();
		result.append(this.bronzeGoal);
		result.append(" \u2192 ");
		result.append(this.bronzeReward);

		return result.toString();
	}
}
