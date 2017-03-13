package pl.pollub53.springBus.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tobiasz on 2017-01-13.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, length = 50)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

//    @ManyToOne
//    @JoinColumn(name = "username")
//    private User user;
//    public User getUser(){
//        return user;
//    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "id='" + id+ '\'' +
                "role='" + role + '\'' +
                '}';
    }



}
