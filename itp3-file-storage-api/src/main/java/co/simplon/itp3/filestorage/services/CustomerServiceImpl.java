package co.simplon.itp3.filestorage.services;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${itp3-file-storage-api.send-mail-endpoint}")
    private String apiUrl;

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
	customer.setCustomerNumber(
		customers.getNextSeriesCustomerNumber());
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

	callExternalAPI(customer.getEmail(), hashedApiKey);
	customers.save(customer);
    }

    private void callExternalAPI(String recipientEmail,
	    String hashedApiKey) {

	SendEmailDto emailDto = new SendEmailDto();
	emailDto.setPrimaryRecipient(recipientEmail);
	emailDto.setSender("no-reply.dev@readresolve.io");
	emailDto.setSubject("apiKey");
	emailDto.setBody(hashedApiKey);

	restTemplate.postForObject(apiUrl, emailDto,
		String.class);

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
