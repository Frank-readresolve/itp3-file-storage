package co.simplon.itp3.filestorage.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.CustomerData;
import co.simplon.itp3.filestorage.entities.Customer;
import co.simplon.itp3.filestorage.entities.Role;
import co.simplon.itp3.filestorage.repositories.CustomerRepository;
import co.simplon.itp3.filestorage.repositories.RoleRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private CustomerRepository customers;
    private RoleRepository roles;

    public CustomerServiceImpl(CustomerRepository customers,
	    RoleRepository roles) {
	this.customers = customers;
	this.roles = roles;
    }

    @Override
    @Transactional
    public void create(@Valid CustomerData inputs) {
	Customer customer = new Customer();
	customer.setCustomerName(inputs.getCustomerName());
	customer.setCustomerNumber(
		customers.getNextSeriesCustomerNumber());
	customer.setFirstName(inputs.getFirstName());
	customer.setLastName(inputs.getLastName());
	customer.setEmail(inputs.getEmail());
	customer.setConsent(inputs.getConsent());
	Long roleId = inputs.getRoleId();
	Role role = roles.getReferenceById(roleId);
	customer.setRoleId(role);
	;
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
