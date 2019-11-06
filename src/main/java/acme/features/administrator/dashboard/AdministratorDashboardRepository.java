
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select r.sector from InvestorRecord r")
	String[] investorSector();

	@Query("select sector,count(r) from InvestorRecord r group by r.sector")
	String[] dataInvestor();

	@Query("select c.workSector from CompanyRecords c")
	String[] companySector();

	@Query("select workSector,count(c) from CompanyRecords c group by c.workSector")
	String[] dataCompany();
}
