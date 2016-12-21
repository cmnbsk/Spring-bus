package pl.pollub53.springBus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "customer_last_name", nullable = false, length = 45)
    private String lastName;
    @Column(name = "customer_first_name", nullable = false, length = 45)
    private String firstName;
    @Column(name = "customer_pesel", nullable = false, length = 11)
    private String pesel;
    @Column(name = "customer_email", length = 45)
    private String email;
    @Column(name = "customer_phone", nullable = false, length = 9)
    private String phone;

    @ManyToMany(mappedBy = "customers")
    private List<Course> courses;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
