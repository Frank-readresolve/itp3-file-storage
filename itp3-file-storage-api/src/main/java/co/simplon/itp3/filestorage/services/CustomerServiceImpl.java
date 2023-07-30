package co.simplon.itp3.filestorage.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.CustomerData;
import co.simplon.itp3.filestorage.entities.Customer;
import co.simplon.itp3.filestorage.repositories.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customers;

    public CustomerServiceImpl(CustomerRepository customers) {
	this.customers = customers;
    }

    @Override
    @Transactional
    public void create(CustomerData inputs) {
	Customer customer = new Customer();
	customer.setCustomerName(inputs.getCustomerName());
	customer.setCustomerNumber(customers.getNextSeriesCustomerNumber());
	customer.setFirstName(inputs.getFirstName());
	customer.setLastName(inputs.getLastName());
	customer.setEmail(inputs.getEmail());
	customer.setConsent(inputs.getConsent());
	customers.save(customer);
    }

    @Override
    public Boolean existsByCustomerName(String name) {
	return customers.existsByCustomerName(name);
    }

    @Override
    public Boolean existsByEmail(String email) {
	return customers.existsByEmail(email);
    }
}
