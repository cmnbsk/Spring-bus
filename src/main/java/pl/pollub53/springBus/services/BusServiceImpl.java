package pl.pollub53.springBus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.entity.Bus;
import pl.pollub53.springBus.repositories.BusRepository;

import java.util.List;


@Service
public class BusServiceImpl implements BusService {
    private BusRepository busRepository;

    @Autowired
    public void setBusRepository(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Bus> getBuses() {
        return busRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Bus getBusById(long id) {
        return busRepository.findOne(id);
    }

    @Override
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(long id) {
        busRepository.delete(id);

    }


}
