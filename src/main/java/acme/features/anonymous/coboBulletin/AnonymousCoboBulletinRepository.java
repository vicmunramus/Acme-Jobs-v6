
package acme.features.anonymous.coboBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.coboBulletin.CoboBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousCoboBulletinRepository extends AbstractRepository {

	@Query("select b from CoboBulletin b")
	Collection<CoboBulletin> findMany();
}
