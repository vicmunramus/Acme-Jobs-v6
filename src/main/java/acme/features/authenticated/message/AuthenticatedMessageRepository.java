
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.entities.messages.Message;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	//used in list
	@Query("select m from Message m where m.messageThread.id = ?1")
	Collection<Message> findManyMessageByMessageThread(int id);
	//used in form
	@Query("select m from Message m where m.id = ?1")
	Message findOneMessageById(int id);
	//used in create->instantiate
	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountdById(int id);
	//used in create->create
	@Query("select m from MessageThread m WHERE m.title = ?1")
	MessageThread findOneMessageThreadByTitle(String msgThreadTitle);
	//used in authorise
	@Query("select COUNT(m) from MessageThread m WHERE ?1 IN (select ua.id FROM m.involvedUsers ua WHERE ua.id = ?1) OR ?1 = m.creator.id AND m.id=?2")
	Integer existUserAccountInMessageThread(int userAccountId, int messageThreadId);
}
