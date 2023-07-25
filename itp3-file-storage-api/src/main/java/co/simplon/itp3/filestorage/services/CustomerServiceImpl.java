package co.simplon.itp3.filestorage.services;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl
	implements CustomerService {

    private CustomerRepository customers;

    public CustomerServiceImpl(
	    CustomerRepository customers) {
	this.customers = customers;

    }

    @Override
    public void create(CustomerData inputs) {
	Customer customer = new Customer();
	customer.setCustomer_name(
		inputs.getCustomer_name());
	customer.setFirst_Name(inputs.getFirst_Name());
	customer.setLast_Name(inputs.getLast_Name());
	customer.setEmail(inputs.getEmail());
	customer.setConsent(inputs.getConsent());
	this.customers.save(customer);

    }

}
