
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j WHERE j.id IN(select a.job.id from AuditRecords a where a.auditor.id = ?1)")
	Collection<Job> findMyJobs(int auditorId);

	@Query("select j from Job j WHERE j.id NOT IN(select a.job.id from AuditRecords a where a.auditor.id = ?1)")
	Collection<Job> findManyJobs(int auditorId);

	@Query("select j from Job j WHERE j.id = ?1")
	Job findOne(int auditRecordId);

	@Query("select count(a) from AuditRecords a WHERE a.job.id = ?1 AND a.auditor.id = ?2")
	Integer checkIfAuditRecordExist(int jobId, int auditorId);

}
