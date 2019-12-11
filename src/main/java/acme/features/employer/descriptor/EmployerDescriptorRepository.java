
package acme.features.employer.descriptor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDescriptorRepository extends AbstractRepository {

	@Query("select d from Descriptor d where d.job.id = ?1")
	Descriptor findOneDescriptorByJobId(int jobId);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int jobId);

	@Query("select d from Descriptor d where d.id = ?1")
	Descriptor findOneDescriptorById(int id);

	@Query("select d from Duty d where d.descriptor.id = ?1")
	Collection<Duty> findManyDutiesByDescriptorId(int descriptorId);
}
