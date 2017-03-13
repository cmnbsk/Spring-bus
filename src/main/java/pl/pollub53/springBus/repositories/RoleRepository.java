package pl.pollub53.springBus.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.domain.Role;
import pl.pollub53.springBus.domain.User;

import java.util.Set;

public interface RoleRepository extends JpaRepository<User, Long> {

    Set<Role> findByUsername(String username);
}
