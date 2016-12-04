package pl.pollub53.springBus.entity;

import javax.persistence.*;

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
    private long phone;

    protected Company() {
    }

    public Company(long name, String email, String website, long phone) {
        this.name = name;
        this.email = email;
        this.website = website;
        this.phone = phone;
    }

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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
