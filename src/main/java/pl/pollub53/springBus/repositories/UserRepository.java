package pl.pollub53.springBus.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
