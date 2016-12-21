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
@RequestMapping("/buses")
public class BusController {
    private BusService busService;

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    /*na stronie /buses ma wyświetlić się lista autobusów

      metoda get - do pobierania danych z serwera */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        //wykorzystuję metodę getBuses() z repozytorium
        model.addAttribute("buses", busService.getBuses());

        System.out.println("Zwrócono autobusy:");
        return "buses";
    }

    //po przejściu do odnośnika z RequestMapping() wywoływana jest metoda
    @RequestMapping("/{id}")
    public String showBus(@PathVariable long id, Model model) {
        model.addAttribute("buses", busService.getBusById(id));
        return "busshow";
    }

    //PathVariable jest to zmienna pobrana ze ścieżki HTTP
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("buses", busService.getBusById(id));
        return "buses/busform";
    }

    @RequestMapping("/new")
    public String newBus(Model model) {
        model.addAttribute("buses", new Bus());
       return "busform";
        // return "buses/busform";
    }
/*
    //POST używamy, gdy chcemy tworzyć, aktualizować i usuwać dane po stronie serwera
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBus(Bus bus) {
        busService.saveBus(bus);
        return "redirect:/buses/save/" + bus.getId();
    }
*/

    @RequestMapping(value = "/buses", method = RequestMethod.POST)
    public String saveBus(Bus bus) {
        busService.saveBus(bus);
        return "redirect:/buses/" + bus.getId();
    }
    ////////usuwanie autobusu - Głowy nie dam, czy to na pewno tak powinno być
    @RequestMapping(value = "/delete/{id}")
    public String deleteBus(@PathVariable long id) {
        busService.deleteBus(id);
        return "redirect:/buses/delete";
    }

}
