package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanies();

    Company getCompanyById(long id);

    Company saveCompany(Company company);

    void deleteCompany(long id);

    Company updateCompany(Company company);
}
