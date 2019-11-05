
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(r) from InvestorRecord r where r.sector = 'Primary sector'")
	Integer findPrimarySectorInvestorRecord();

	@Query("select count(r) from InvestorRecord r where r.sector = 'Secondary sector'")
	Integer findSecondarySectorInvestorRecord();

	@Query("select count(r) from InvestorRecord r where r.sector = 'Service sector'")
	Integer findServiceSectorInvestorRecord();

	@Query("select count(r) from CompanyRecords r where r.workSector = 'Primary sector'")
	Integer findPrimarySectorCompanyRecord();

	@Query("select count(r) from CompanyRecords r where r.workSector = 'Secondary sector'")
	Integer findSecondarySectorCompanyRecord();

	@Query("select count(r) from CompanyRecords r where r.workSector = 'Service sector'")
	Integer findServiceSectorCompanyRecord();

}
