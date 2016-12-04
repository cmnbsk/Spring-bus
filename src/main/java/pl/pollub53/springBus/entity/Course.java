package pl.pollub53.springBus.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

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
    private Date date;
    @Column(name = "course_time", nullable = false)
    private Time time;

    protected Course() {
    }

    public Course(float price, String track, Date date, Time time) {
        this.price = price;
        this.track = track;
        this.date = date;
        this.time = time;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
