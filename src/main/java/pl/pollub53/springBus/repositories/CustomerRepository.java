package pl.pollub53.springBus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

