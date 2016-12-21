package pl.pollub53.springBus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.entity.Bus;

//proszę sobie kliknąć z Ctrl na JpaRepository --> tam są fajne metody które można wykorzystać w innych klasach
public interface BusRepository extends JpaRepository<Bus, Long> {

}
