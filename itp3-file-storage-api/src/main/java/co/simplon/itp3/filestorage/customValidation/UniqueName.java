package co.simplon.itp3.filestorage.customValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

<<<<<<< HEAD
=======
import javax.validation.Constraint;
>>>>>>> 5f72684f5fb2f160a3401762ae72cefba270664d
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueNameValidator.class)

public @interface UniqueName {
    String message() default "It should be a unique name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
