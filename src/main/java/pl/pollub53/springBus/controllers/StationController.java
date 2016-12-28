package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Station;
import pl.pollub53.springBus.services.StationService;

@Controller
@SessionAttributes("station")
public class StationController {
    private StationService stationService;

    @Autowired
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("station/list")
    public String list(Model model) {
        model.addAttribute("station", stationService.getStations());
        return "station/stations";
    }

    @GetMapping("station/new")
    public String newStation(Model model) {
        model.addAttribute("station", new Station());
        return "station/stationform";
    }

    @PostMapping("station/save")
    public String saveStation(@ModelAttribute("station") Station station) {
        stationService.saveStation(station);
        return "redirect:/station/" + station.getId();
    }

    @GetMapping("station/{id}")
    public String showStation(@PathVariable long id, Model model) {
        model.addAttribute("station", stationService.getStationById(id));
        return "station,stationform";
    }

    @GetMapping("station/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Station station = stationService.getStationById(id);
        if (station == null) {
            return "notExist";
        }
        model.addAttribute("station", station);
        return "station/stationform";
    }

    @GetMapping("station/delete/{id}")
    public String deleteStation(@PathVariable long id) {
        stationService.deleteStation(id);
        return "redirect:/customer/" + id;
    }
}
