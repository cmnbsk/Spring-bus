package pl.pollub53.springBus.entity;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "bus_places",nullable = false, length = 4)
    private int places;
    @Column(name = "bus_is_available",nullable = false)
    private boolean isAvailable;

    protected Bus(){}

    public Bus(int places, boolean isAvailable) {
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
