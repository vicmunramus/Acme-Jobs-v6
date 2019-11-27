
package acme.features.auditor.auditRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select a from AuditRecords a where a.auditor.id = ?1")
	Collection<AuditRecords> findManyByAuditorId(int auditorId);

	@Query("select a from AuditRecords a where a.auditor.id != ?1")
	Collection<AuditRecords> findManyJobsByAuditorId(int auditorId);

	@Query("select a from AuditRecords a where a.auditor.id != ?1 AND a.status = 1")
	Collection<AuditRecords> findManyJobsByAuditorIdAndValid(int auditorId);

	@Query("select a from AuditRecords a where a.id = ?1")
	AuditRecords findOne(int auditRecordId);
}
