package pl.pollub53.springBus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
