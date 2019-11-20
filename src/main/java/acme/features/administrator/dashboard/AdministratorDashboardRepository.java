
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select distinct r.sector from InvestorRecord r")
	String[] investorSector();

	@Query("select sector,count(r) from InvestorRecord r group by r.sector")
	String[] dataInvestor();

	@Query("select distinct c.workSector from CompanyRecords c")
	String[] companySector();

	@Query("select workSector,count(c) from CompanyRecords c group by c.workSector")
	String[] dataCompany();

	//Listing

	@Query("select count(r) from Announcement r")
	Integer countAllAnnouncement();

	@Query("select count(r) from CompanyRecords r")
	Integer countAllCompanyRecord();

	@Query("select count(r) from InvestorRecord r")
	Integer countAllInvestorRecord();

	@Query("select max(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMaxOffer();

	@Query("select min(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMinOffer();

	@Query("select max(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getMaxRequest();

	@Query("select min(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getMinRequest();

	@Query("select avg(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getAvgRequest();

	@Query("select stddev(r.reward.amount) from Request r where r.deadline > utc_timestamp()")
	Double getStdRequest();

	//Querys no directas

	@Query("select avg(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMaxAvgOffer();

	@Query("select avg(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getMinAvgOffer();

	@Query("select stddev(r.maxReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getStdMaxOffer();

	@Query("select stddev(r.minReward.amount) from Offer r where r.deadline > utc_timestamp()")
	Double getStdMinOffer();
}
