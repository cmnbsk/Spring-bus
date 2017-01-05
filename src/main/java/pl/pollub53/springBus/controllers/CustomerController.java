package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Customer;
import pl.pollub53.springBus.services.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCourseService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/list")
    public String list(Model model) {
        model.addAttribute("customer", customerService.getCustomers());
        return "customer/customers";
    }

    @GetMapping("customer/new")
    public String newCourse(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @PostMapping("customer/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/" + customer.getId();
    }

    @GetMapping("customer/{id}")
    public String showCustomer(@PathVariable long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/customerform";
    }

    @GetMapping("customer/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return "notExist";
        }
        model.addAttribute("customer", customer);
        return "customer/customerform";
    }

    @GetMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/" + id;
    }
}
