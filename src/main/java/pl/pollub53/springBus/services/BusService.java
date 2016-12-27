package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Bus;

import java.util.List;

public interface BusService {
    //weź listę wszystkich autobusów
    List<Bus> getBuses();

    //weź autobus po id
    Bus getBusById(long id);

    //zapisz autobus
    Bus saveBus(Bus bus);

    //usuń autobus
    void deleteBus(long id);

    //update autobus
    Bus updateBus(Bus bus);
}
