package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(long id);

    Customer updateCustomer(Customer customer);
}
