/*
 * AuthenticatedUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.userAccount;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedUserAccountRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select ua.involvedUsers,ua.creator from MessageThread ua where ua.id = ?1")
	Collection<UserAccount> findManyUserAccountByMessageThreadId(int id);
	//used in authorise
	@Query("select COUNT(m) from MessageThread m WHERE ?1 IN (select ua.id FROM m.involvedUsers ua WHERE ua.id = ?1) OR ?1 = m.creator.id AND m.id=?2")
	Integer existUserAccountInMessageThread(int userAccountId, int messageThreadId);
}
