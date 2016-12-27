package pl.pollub53.springBus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.domain.Bus;
import pl.pollub53.springBus.repositories.BusRepository;

import javax.persistence.NoResultException;
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
    public void deleteBus(long id) { busRepository.delete(id); }

    //update not used
    @Override
    public Bus updateBus(Bus bus) throws NoResultException{
        Bus foundBus = busRepository.findOne(bus.getId());
        if(foundBus == null){
            throw new NoResultException("Cannot update bus. Bus doesn't exist");
        }
        return busRepository.save(bus);
    }
}
