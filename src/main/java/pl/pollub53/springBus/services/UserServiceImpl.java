package pl.pollub53.springBus.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.pollub53.springBus.domain.Role;
import pl.pollub53.springBus.domain.User;
import pl.pollub53.springBus.repositories.RoleRepository;
import pl.pollub53.springBus.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepository;
//    TODO hash password nad authorities https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User create(User user){
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepo.findOne(username);
    }

//    @Override
//    public User create(User user) {
//        return this.userRepo.save(user);
//    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        this.userRepo.delete(username);
    }

//    @Override
//    public boolean authenticate(String username, String password) {
//        // Provide a sample password check: username == password
//        return Objects.equals(username, password);
//    }
}