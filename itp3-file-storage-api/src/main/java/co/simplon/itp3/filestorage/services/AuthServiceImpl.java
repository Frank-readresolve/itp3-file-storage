package co.simplon.itp3.filestorage.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.filestorage.dtos.CustomerView;
import co.simplon.itp3.filestorage.repositories.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customers;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(CustomerRepository customers,
	    BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.customers = customers;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void authenticate(String customerNumber,
	    String rawKey) throws BadCredentialsException {
	if ((customerNumber == null)
		|| customerNumber.equals("")) {
	    throw new BadCredentialsException(
		    String.format("Customer not found"));
	}
	CustomerView client = customers
		.findByCustomerNumber(
			Long.valueOf(customerNumber))
		.orElseThrow(
			() -> new BadCredentialsException(
				String.format(
					"Customer not found with customer name '%s'",
					customerNumber)));
	if (!bCryptPasswordEncoder.matches(rawKey,
		client.getApiKey())) {
	    throw new BadCredentialsException(String.format(
		    "Bad API Key for client with name '%s'",
		    customerNumber));
	}

    }

}
