package pl.pollub53.springBus.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "course_price", nullable = false)
    private float price;
    @Column(name = "course_track", nullable = false, length = 45)
    private String track;
    @Column(name = "course_date", nullable = false)
    private String date;
    @Column(name = "course_time", nullable = false)
    private String time;

    //wiele kursów może mieć jeden autobus (np. autobus o nr rej. LU 25884 może jeździć z Warszawy do Krakowa lub z Lublina do Gdańska)
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


    //wiele kursów może mieć wiele klientów (czyli 1 klient może mieć wiele kursów i 1 kurs może mieć wiele klientów)
    @ManyToMany
    @JoinTable(name = "customers_in_courses", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private List<Customer> customers;

    //wiele kursów może mieć jednego przewoźnika
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    public long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", price=" + price +
                ", track='" + track + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
