package co.simplon.itp3.filestorage.services;

import java.util.ArrayList;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import co.simplon.itp3.filestorage.dtos.CustomerData;
import co.simplon.itp3.filestorage.dtos.SendEmailDto;
import co.simplon.itp3.filestorage.entities.Customer;
import co.simplon.itp3.filestorage.entities.Role;
import co.simplon.itp3.filestorage.repositories.CustomerRepository;
import co.simplon.itp3.filestorage.repositories.RoleRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private final RestTemplate restTemplate;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final CustomerRepository customers;

    private final RoleRepository roles;

    public CustomerServiceImpl(CustomerRepository customers,
	    RoleRepository roles,
	    BCryptPasswordEncoder bCryptPasswordEncoder,
	    RestTemplate restTemplate) {
	this.customers = customers;
	this.roles = roles;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	this.restTemplate = restTemplate;

    }

    @Override
    @Transactional
    public void create(@Valid CustomerData inputs) {
	Customer customer = new Customer();
	customer.setCustomerName(inputs.getCustomerName());
	Long customerNumber = customers
		.getNextSeriesCustomerNumber();
	String customerNumberString = String
		.valueOf(customerNumber);
	customer.setCustomerNumber(customerNumber);
	customer.setFirstName(inputs.getFirstName());
	customer.setLastName(inputs.getLastName());
	customer.setEmail(inputs.getEmail());
	customer.setConsent(inputs.getConsent());
	Long roleId = inputs.getRoleId();
	Role role = roles.getReferenceById(roleId);
	customer.setRoleId(role);
	String apiKey = UUID.randomUUID().toString();
	String hashedApiKey = bCryptPasswordEncoder
		.encode(apiKey);
	customer.setApiKey(hashedApiKey);
	callExternalAPI(customer.getEmail(), apiKey,
		customerNumberString);
	customers.save(customer);
    }

    private void callExternalAPI(String recipientEmail,
	    String apiKey, String customerNumber) {

	SendEmailDto emailDto = new SendEmailDto();
	ArrayList<String> recipientList = new ArrayList<>();
	recipientList.add(recipientEmail);
	emailDto.setPrimaryRecipient(recipientList);
	emailDto.setSender("no-reply.dev@readresolve.io");
	emailDto.setSubject("Identifiers");
	String body = "Customer Number : " + customerNumber
		+ " API key : " + apiKey;
	emailDto.setBody(body);

	restTemplate.postForObject("/send-attached-mail",
		emailDto, String.class);

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
