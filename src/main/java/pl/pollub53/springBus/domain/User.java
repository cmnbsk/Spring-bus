package pl.pollub53.springBus.domain;

import javax.persistence.*;
import java.util.Set;

//TODO dodać strukturę katalogów security

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false, length = 50, unique = true)
    private String username;
    @Column(nullable = false, length = 50)
    private String password;
    @Column()
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private Set<Role> roles;

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles){ this.roles = roles; }

    //jeden user może mieć wiele authorities
//    @OneToMany(mappedBy = "user")
//    private Set<Authorities> authorities;

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

    public boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled='" + enabled + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
