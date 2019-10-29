
package acme.features.anonymous.reinaBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.reinaBulletin.ReinaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousReinaBulletinRepository extends AbstractRepository {

	@Query("select b from ReinaBulletin b")
	Collection<ReinaBulletin> findMany();
}
