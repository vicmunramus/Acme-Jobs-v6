
package acme.features.auditor.auditRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecords;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorAuditRecordListService implements AbstractListService<Auditor, AuditRecords> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AuditRecords> request, final AuditRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "job", "job.reference", "job.title", "job.deadline");
	}

	@Override
	public Collection<AuditRecords> findMany(final Request<AuditRecords> request) {
		assert request != null;

		Collection<AuditRecords> result;
		Principal principal;

		principal = request.getPrincipal();

		result = this.repository.findManyJobsByAuditorIdAndValid(principal.getActiveRoleId());

		return result;
	}
}
