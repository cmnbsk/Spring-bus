package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User create(User user);

    User edit(User user);

    void deleteByUsername(String username);

    //boolean authenticate(String username, String password);
}
