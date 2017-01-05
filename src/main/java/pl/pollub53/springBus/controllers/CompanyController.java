package pl.pollub53.springBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.domain.Company;
import pl.pollub53.springBus.services.CompanyService;

@Controller
@SessionAttributes("company")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("company/list")
    public String list(Model model) {
        model.addAttribute("company", companyService.getCompanies());
        return "company/companies";
    }

    @GetMapping("company/new")
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/companyform";
    }

    @PostMapping("company/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company/" + company.getId();
    }

    @GetMapping("company/{id}")
    public String showCompany(@PathVariable long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company/companyform";
    }

    @GetMapping("company/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Company company = companyService.getCompanyById(id);
        if (company == null) {
            return "notExist";
        }
        model.addAttribute("company", company);
        return "company/companyform";
    }

    @GetMapping("company/delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        companyService.deleteCompany(id);
        return "redirect:/company/" + id;
    }

}
