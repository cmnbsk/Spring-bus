package pl.pollub53.springBus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.domain.Company;
import pl.pollub53.springBus.repositories.CompanyRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.delete(id);
    }

    @Override
    public Company updateCompany(Company company) throws NoResultException {
        Company foundCompany = companyRepository.findOne(company.getId());
        if (foundCompany == null) {
            throw new NoResultException("Cannot update company. Company doesn't exist");
        }
        return companyRepository.save(company);
    }
}
