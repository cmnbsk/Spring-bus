package pl.pollub53.springBus.services;

/**
 * Created by Tobiasz on 2016-12-28.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}
