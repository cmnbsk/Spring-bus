package pl.pollub53.springBus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class LoginForm {
    @Size(min = 2, max = 30, message = "Nazwa użytkownika musi być w przedziale 2-30")
    private String username;

    @NotNull
    @Size(min = 4, max = 30, message = "Hasło musi być w przedziale 4-30")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}