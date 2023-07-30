package co.simplon.itp3.filestorage.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.filestorage.services.SubscriptionService;

public class UniqueSubscriptionNameValidator implements
	ConstraintValidator<UniqueSubscriptionName, String> {

    private SubscriptionService service;

    public UniqueSubscriptionNameValidator(
	    SubscriptionService service) {

	this.service = service;
    }

    @Override
    public boolean isValid(String value,
	    ConstraintValidatorContext context) {
	if (value == null) {
	    return true;
	}
	if (service.existsBySubscriptionName(value)) {
	    return false;
	}
	return true;
    }

}
