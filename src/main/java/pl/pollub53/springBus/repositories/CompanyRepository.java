package pl.pollub53.springBus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
