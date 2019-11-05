
package acme.features.administrator.spams;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spams.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamsRepository extends AbstractRepository {

	@Query("select s from Spam s")
	Collection<Spam> findMany();

}
