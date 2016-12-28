package pl.pollub53.springBus.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.domain.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

}
