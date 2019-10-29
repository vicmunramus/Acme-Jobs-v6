
package acme.features.anonymous.munozBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.munozBulletins.MunozBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousMunozBulletinRepository extends AbstractRepository {

	@Query("select s from MunozBulletin s")
	Collection<MunozBulletin> findMany();
}
