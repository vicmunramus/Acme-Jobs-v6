
package acme.features.auditor.auditRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecords;
import acme.entities.auditRecords.Status;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorAuditRecordShowService implements AbstractShowService<Auditor, AuditRecords> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecords> request) {
		assert request != null;

		boolean result;

		int auditRecordId;
		AuditRecords auditRecord;
		Auditor auditor;
		Principal principal;

		auditRecordId = request.getModel().getInteger("id");
		auditRecord = this.repository.findOne(auditRecordId);
		auditor = auditRecord.getAuditor();
		principal = request.getPrincipal();
		result = auditRecord.getStatus() == Status.PUBLISHED || auditRecord.getStatus() != Status.PUBLISHED && auditor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<AuditRecords> request, final AuditRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "job", "job.reference", "job.title", "job.deadline", "job.salary", "job.moreInfo", "job.description");
	}

	@Override
	public AuditRecords findOne(final Request<AuditRecords> request) {
		assert request != null;

		AuditRecords a;
		int id;

		id = request.getModel().getInteger("id");
		a = this.repository.findOne(id);

		return a;
	}
}
