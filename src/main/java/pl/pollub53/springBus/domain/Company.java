package pl.pollub53.springBus.domain;

import javax.persistence.*;
import java.util.List;

//Company=przewoźnik
@Entity
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "company_name", nullable = false, length = 45)
    private long name;
    @Column(name = "company_email", nullable = false, length = 45)
    private String email;
    @Column(name = "company_website", length = 30)
    private String website;
    @Column(name = "company_phone", nullable = false, length = 9)
    private String phone;

    //jedna firma może mieć wiele autobusów
    @OneToMany(mappedBy = "company")
    private List<Bus> buses;

    //jedna firma może mieć wiele kursów
    @OneToMany(mappedBy = "company")
    private List<Course> courses;


    public long getId() {
        return id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", phone=" + phone +
                '}';
    }
}
