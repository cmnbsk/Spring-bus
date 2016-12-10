package pl.pollub53.springBus.entity;

import org.springframework.data.jpa.repository.JpaRepository;

//proszę sobie kliknąć z Ctrl na JpaRepository --> tam są fajne metody które można wykorzystać w innych klasach
public interface BusRepository extends JpaRepository<Bus, Long> {
}
