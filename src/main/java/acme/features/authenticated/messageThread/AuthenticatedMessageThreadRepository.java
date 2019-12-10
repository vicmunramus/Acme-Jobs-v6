
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	//	@Query("select m from MessageThread m WHERE m.creator.id=?1")
	//	@Query("select m from MessageThread m WHERE m.creator.id = ?1")
	//	Collection<MessageThread> findManyMessageThreadsByCreatorId(int id);

	@Query("select m from MessageThread m WHERE ?1 IN (select ua.id FROM m.involvedUsers ua WHERE ua.id = ?1) OR ?1 = m.creator.id")
	Collection<MessageThread> findManyMessageThreadsByUserAccountId(int id);

	@Query("select m from MessageThread m WHERE m.id = ?1")
	MessageThread findOneMessageThread(int msgThreadId);

	@Query("select COUNT(m) from MessageThread m WHERE ?1 IN (select ua.id FROM m.involvedUsers ua WHERE ua.id = ?1) OR ?1 = m.creator.id AND m.id=?2")
	Integer existAuthenticatedByMessageThreadId(int userAccountId, int messageThreadId);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountdById(int id);
}
