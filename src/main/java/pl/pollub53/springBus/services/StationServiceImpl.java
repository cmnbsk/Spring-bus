package pl.pollub53.springBus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.domain.Station;
import pl.pollub53.springBus.repositories.StationRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Station getStationById(long id) {
        return stationRepository.findOne(id);
    }

    @Override
    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public void deleteStation(long id) {
        stationRepository.delete(id);
    }

    @Override
    public Station updateStation(Station station) throws NoResultException {
        Station foundStation = stationRepository.findOne(station.getId());
        if (foundStation == null) {
            throw new NoResultException("Cannot update station. Station doesn't exist");
        }
        return stationRepository.save(station);
    }
}
