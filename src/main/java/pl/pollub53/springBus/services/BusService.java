package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Bus;

import java.util.List;

public interface BusService {
    //weź listę wszystkich autobusów
    List<Bus> getBuses();

    Bus getBusById(long id);

    Bus saveBus(Bus bus);

    void deleteBus(long id);

    //nieużywane
    //Bus updateBus(Bus bus);
}
