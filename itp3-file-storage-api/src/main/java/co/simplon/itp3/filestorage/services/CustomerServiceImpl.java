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
	customer.setCustomer_name(inputs.getCustomer_name());
	customer.setFirst_name(inputs.getFirst_name());
	customer.setLast_name(inputs.getLast_name());
	customer.setEmail(inputs.getEmail());
	customer.setConsent(inputs.getConsent());
	this.customers.save(customer);
    }

}
