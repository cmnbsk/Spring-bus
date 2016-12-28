package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
