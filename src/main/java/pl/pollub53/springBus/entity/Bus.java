package pl.pollub53.springBus.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Bus {
    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.AUTO) //id jest generowane automatycznie
    private long id;
    @Column(name = "bus_registration_number", nullable = false, length = 10)
    private String registration_number;
    @Column(name = "bus_seats", nullable = false, length = 4)
    private int seats;
    @Column(name = "bus_is_available", nullable = false)
    private boolean available;

    //jeden autobus może mieć wiele kursów
    @OneToMany(mappedBy = "bus")
    private List<Course> courses;

    //wiele autobusów może mieć wiele przystanków
    @ManyToMany
    @JoinTable(name = "stations_in_buses", joinColumns = {@JoinColumn(name = "bus_id")},
            inverseJoinColumns = {@JoinColumn(name = "station_id")})
    private List<Station> stations;

    //wiele autobusów może mieć jednego przewoźnika
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    public long getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    @Override
    public String toString() {
        return "Bus{" +
                " = " + id +
                ", registration number = " + registration_number +
                ", seats = " + seats +
                ", isAvailable = " + available +
                '}';
    }


}
