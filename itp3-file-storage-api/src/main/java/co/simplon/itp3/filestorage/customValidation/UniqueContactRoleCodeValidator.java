package co.simplon.itp3.filestorage.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.filestorage.services.RoleService;

public class UniqueContactRoleCodeValidator
	implements ConstraintValidator<UniqueContactRoleCode, String> {

    private RoleService service;

    public UniqueContactRoleCodeValidator(RoleService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	if (value == null) {
	    return true;
	}

	if (service.existsByContactRoleCode(value)) {
	    return false;
	}
	return true;
    }

}
