package tech.trainning.trainningspringvalidation.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = GenderConstraintValidator.class)
public @interface GenderConstraint {

    String description() default "enum";
    String message() default "{validation.constraints.enum}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
