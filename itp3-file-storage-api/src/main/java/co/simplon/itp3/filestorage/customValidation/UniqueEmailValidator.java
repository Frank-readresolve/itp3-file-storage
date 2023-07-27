package co.simplon.itp3.filestorage.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.filestorage.services.CustomerService;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private CustomerService service;

    public UniqueEmailValidator(CustomerService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	if (value == null) {
	    return true;
	}

	if (service.existsByEmail(value)) {
	    return false;
	}
	return true;
    }

}
