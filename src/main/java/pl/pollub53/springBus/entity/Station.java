package pl.pollub53.springBus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Station {
    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "station_name", nullable = false,length =45 )
    private String name;

    @ManyToMany(mappedBy = "stations")
    private List<Bus> buses;

    protected Station(){}

    public Station(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
