package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pollub53.springBus.entity.Bus;
import pl.pollub53.springBus.services.BusService;

//żeby sprawdzić, czy kontroler działa, trzeba zrobić widok (html&JavaScript)

@Controller
public class BusController {
    private BusService busService;

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    /*na stronie /buses ma wyświetlić się lista autobusów

      metoda get - do pobierania danych z serwera */
    @RequestMapping(value = "/bus/list", method = RequestMethod.GET)
    public String list(Model model) {

        //wykorzystuję metodę getBuses() z repozytorium
        model.addAttribute("bus", busService.getBuses());
        return "bus/buses";
    }

    //po przejściu do odnośnika z RequestMapping() wywoływana jest metoda
    @RequestMapping("bus/{id}")
    public String showBus(@PathVariable long id, Model model) {
        model.addAttribute("bus", busService.getBusById(id));
        return "bus/busform";
    }

    //PathVariable jest to zmienna pobrana ze ścieżki HTTP
    @RequestMapping("bus/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("bus", busService.getBusById(id));
        return "bus/busformEdit";
    }

    @RequestMapping("bus/new")
    public String newBus(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus/busform";
    }

    @RequestMapping(value = "bus/save", method = RequestMethod.POST)
    public String saveBus(Bus bus) {
        busService.saveBus(bus);
        return "redirect:/bus/" + bus.getId();
    }

    //usuwanie autobusu - Głowy nie dam, czy to na pewno tak powinno być
    @RequestMapping(value = "bus/delete/{id}")
    public String deleteBus(@PathVariable long id) {
        busService.deleteBus(id);
        return "redirect:/bus/" + id;
    }

    @RequestMapping(value = "bus/update", method = RequestMethod.POST)
    public String updateBus(Bus bus) {
        busService.updateBus(bus);
        return "redirect:/bus/" + bus.getId();
    }

}
