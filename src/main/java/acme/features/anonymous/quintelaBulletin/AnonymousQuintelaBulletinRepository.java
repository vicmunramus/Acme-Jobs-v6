
package acme.features.anonymous.quintelaBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.quintelaBulletin.QuintelaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousQuintelaBulletinRepository extends AbstractRepository {

	//where author = Quintela
	@Query("select b from QuintelaBulletin b ")
	Collection<QuintelaBulletin> findMany();
}
