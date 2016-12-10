package pl.pollub53.springBus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bus {
    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.AUTO) //id jest generowane automatycznie
    private long id;
    @Column(name = "bus_registration", nullable = false, length = 10)
    private long registration;
    @Column(name = "bus_places", nullable = false, length = 4)
    private int places;
    @Column(name = "bus_is_available", nullable = false)
    private boolean isAvailable;

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

    protected Bus() {
    }

    public Bus(long registration, int places, boolean isAvailable) {
        this.registration = registration;
        this.places = places;
        this.isAvailable = isAvailable;
    }

    public long getId() {
        return id;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", places=" + places +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
