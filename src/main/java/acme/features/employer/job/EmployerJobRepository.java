
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j.job from Descriptor j where j.job.id = ?1")
	Job findOneJobById(int id);

	@Query("select j.job from Descriptor j where j.job.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select j from Descriptor j where j.job.id = ?1")
	Descriptor findOneDescriptorById(int jobId);

}
