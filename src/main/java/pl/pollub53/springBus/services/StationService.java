package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Station;

import java.util.List;

public interface StationService {
    List<Station> getStations();

    Station getStationById(long id);

    Station saveStation(Station station);

    void deleteStation(long id);

    Station updateStation(Station station);
}
