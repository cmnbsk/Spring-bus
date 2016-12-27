package pl.pollub53.springBus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.domain.Customer;
import pl.pollub53.springBus.repositories.CustomerRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws NoResultException {
        Customer foundCustomer = customerRepository.findOne(customer.getId());
        if (foundCustomer == null) {
            throw new NoResultException("Cannot update customer. Customer doesn't exist");
        }
        return customerRepository.save(customer);
    }
}
