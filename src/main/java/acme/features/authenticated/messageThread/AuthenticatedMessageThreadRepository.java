
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m WHERE m.id = ?1")
	MessageThread findOneMessageThread(int msgThreadId);

	@Query("select m from MessageThread m WHERE m.creator.id = ?1")
	Collection<MessageThread> findManyMessageThreadByAuthenticatedId(int id);

	@Query("select m from MessageThread m where m.id = ?1")
	MessageThread findOneMessageThreadById(int id);

}
