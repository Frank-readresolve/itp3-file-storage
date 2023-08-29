package co.simplon.itp3.filestorage.customValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueContactRoleCodeValidator.class)
public @interface UniqueContactRoleCode {

    String message() default "The contact role code is already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
