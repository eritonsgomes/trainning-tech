package tech.trainning.trainningspringvalidation.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = GenderEnumConstraintValidator.class)
@NotNull(message = "{validation.constraints.not-null}")
public @interface GenderEnumConstraint {

    String description() default "enum";
    String message() default "{validation.constraints.enum}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
