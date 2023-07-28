package co.simplon.itp3.filestorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.filestorage.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Boolean existsByCustomerName(String name);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT nextval('customer_number_seq')", nativeQuery = true)
    Long getNextSeriesCustomerNumber();
}
