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
@Constraint(validatedBy = UniqueSubscriptionNameValidator.class)
public @interface UniqueSubscriptionName {

    String message() default "Subscription's name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
