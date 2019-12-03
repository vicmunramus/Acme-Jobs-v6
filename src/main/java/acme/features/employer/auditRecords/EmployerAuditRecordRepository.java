
package acme.features.employer.auditRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerAuditRecordRepository extends AbstractRepository {

	@Query("select a from AuditRecords a WHERE a.job.id = ?1")
	Collection<AuditRecords> findManyAuditRecords(int jobId);

	@Query("select a from AuditRecords a WHERE a.id = ?1")
	AuditRecords findOne(int auditId);
}
