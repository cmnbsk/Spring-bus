package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Bus;
import pl.pollub53.springBus.services.BusService;

//żeby sprawdzić, czy kontroler działa, trzeba zrobić widok (html&JavaScript)

@Controller
@SessionAttributes("bus")
public class BusController {
    private BusService busService;

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    /*na stronie /buses ma wyświetlić się lista autobusów

      metoda get - do pobierania danych z serwera */
    @RequestMapping(value = "/bus/list", method = RequestMethod.GET) //get jest domyslnie
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
        Bus bus = busService.getBusById(id);
        if(bus == null){
            return "notExist";
        }
        model.addAttribute("bus", bus);
        return "bus/busform";
    }

    @RequestMapping("bus/new")
    public String newBus(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus/busform";
    }

    //@RequestMapping(value = "bus/save", method = RequestMethod.POST)
    @PostMapping(value = "bus/save")
    public String saveBus(@ModelAttribute("bus") Bus bus) {
        busService.saveBus(bus);
        return "redirect:/bus/" + bus.getId();
    }

    @RequestMapping(value = "bus/delete/{id}")
    public String deleteBus(@PathVariable long id) {
        busService.deleteBus(id);
        return "redirect:/bus/list";
    }

    //tego nie używamy na razie
    @PostMapping(value = "bus/update")
    public String updateBus(@ModelAttribute("bus") Bus bus ) {
        busService.updateBus(bus);
        return "redirect:/bus/" + bus.getId();
    }

}
