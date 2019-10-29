
package acme.features.anonymous.dobladoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.dobladoBulletin.DobladoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousDobladoBulletinRepository extends AbstractRepository {

	@Query("select s from DobladoBulletin s")
	Collection<DobladoBulletin> findMany();
}
