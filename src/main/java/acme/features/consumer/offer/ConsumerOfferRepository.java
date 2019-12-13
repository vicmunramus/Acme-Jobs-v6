
package acme.features.consumer.offer;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ConsumerOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneOfferById(int id);

	@Query("select o from Offer o where o.deadline > ?1")
	Collection<Offer> findManyOffers(Date d);

	@Query("select o from Offer o where o.ticker = ?1")
	Offer findOneOfferByTicker(String ticker);
}
