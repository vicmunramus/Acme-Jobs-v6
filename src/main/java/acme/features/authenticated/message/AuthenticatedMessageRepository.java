
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
	//used in show
	@Query("select m from Message m where m.id = ?1")
	Message findOneMessageById(int id);
	//used in authorise
	@Query("select case when count(m) > 0 then true else false end FROM MessageThread m WHERE m.id = ?2 AND ( m.id IN (SELECT i.messageThread.id FROM Involved i WHERE i.userAccount.id = ?1) OR m.creator.id = ?1)")
	Boolean userInvolvedInMessageThread(int userAccountId, int messageThreadId);
	//used in create
	@Query("select u from UserAccount u WHERE u.id = ?1")
	UserAccount findOneUserAccount(int id);
	//used in create
	@Query("select m from MessageThread m WHERE m.title = ?1")
	MessageThread findOneMessageThreadByTitle(String title);
}
