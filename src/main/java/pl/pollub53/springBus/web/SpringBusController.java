package pl.pollub53.springBus.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpringBusController {

    @RequestMapping("/")
    public String index() {
        return "Pozdrowienia od springBoota!";
    }

    @RequestMapping("/tajne-drzwi")
    public String tk() {
        return "Gratulacje! Znalazłeś pierwsze jajo wielkanocne.";
    }

}