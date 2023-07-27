package co.simplon.itp3.filestorage.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.filestorage.services.CustomerService;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private CustomerService service;

    public UniqueNameValidator(CustomerService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	if (value == null) {
	    return true;
	}

	if (service.existsByCustomerName(value)) {
	    return false;
	}
	return true;
    }
}
