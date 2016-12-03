package pl.pollub53.springBus.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "lastName",nullable = false, length = 45)
    private String lastName;
    @Column(name = "firstName",nullable = false, length = 45)
    private String firstName;
    @Column(name = "pesel",nullable = false, length = 11)
    private String pesel;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "phone",nullable = false, length = 9)
    private long phone;

    protected Customer() {
    }

    public Customer(String lastName, String firstName, String pesel, String email, long phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.email = email;
        this.phone = phone;
    }

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
