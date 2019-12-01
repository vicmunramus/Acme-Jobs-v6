
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m")
	Collection<MessageThread> findManyMessageThreads();
	@Query("select m from Authenticated a JOIN a.messageThread m WHERE a.id = ?1")
	Collection<MessageThread> findManyMessageThreadByAuthenticatedId(int id);
	@Query("select m from MessageThread m where m.id = ?1")
	MessageThread findOneMessageThreadById(int id);

}
