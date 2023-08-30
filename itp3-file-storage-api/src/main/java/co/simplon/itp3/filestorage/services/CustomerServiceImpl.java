package co.simplon.itp3.filestorage.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.CustomerData;
import co.simplon.itp3.filestorage.entities.Customer;
import co.simplon.itp3.filestorage.repositories.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private CustomerRepository customers;

    public CustomerServiceImpl(CustomerRepository customers,
	    BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.customers = customers;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
	String apiKey = UUID.randomUUID().toString();
	String hashedApiKey = bCryptPasswordEncoder.encode(apiKey);
	customer.setApiKey(hashedApiKey);
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
