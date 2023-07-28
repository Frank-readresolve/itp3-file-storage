package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.filestorage.entities.Subscription;

public interface SubscriptionRepository
	extends JpaRepository<Subscription, Long> {

    Boolean existsBySubscriptionName(String name);

    @Query(value = "SELECT nextval('subscription_code_seq')", nativeQuery = true)
    Long getNextSeriesSubscriptionCode();
}
