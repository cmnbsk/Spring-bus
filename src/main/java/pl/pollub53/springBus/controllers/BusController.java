package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Bus;
import pl.pollub53.springBus.services.BusService;

@Controller
@SessionAttributes("bus")
public class BusController {
    private BusService busService;

    @Autowired
    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    @RequestMapping(value = "/bus/list", method = RequestMethod.GET) //get jest domyslnie
    public String list(Model model) {
        model.addAttribute("bus", busService.getBuses());
        return "bus/buses";
    }

    @RequestMapping("bus/{id}")
    public String showBus(@PathVariable long id, Model model) {
        model.addAttribute("bus", busService.getBusById(id));
        return "bus/busform";
    }

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
    /*@PostMapping(value = "bus/update")
    public String updateBus(@ModelAttribute("bus") Bus bus ) {
        busService.updateBus(bus);
        return "redirect:/bus/" + bus.getId();
    }*/
}
