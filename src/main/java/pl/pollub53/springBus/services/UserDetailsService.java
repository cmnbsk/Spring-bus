package pl.pollub53.springBus.services;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Tobiasz on 2016-12-28.
 */
public interface UserDetailsService {

    UserDetails loadUserByUsername(String username);
}
