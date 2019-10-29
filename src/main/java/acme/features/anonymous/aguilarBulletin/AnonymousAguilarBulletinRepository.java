
package acme.features.anonymous.aguilarBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.aguilarBulletins.AguilarBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousAguilarBulletinRepository extends AbstractRepository {

	@Query("select b from AguilarBulletin b")
	Collection<AguilarBulletin> findMany();

}
