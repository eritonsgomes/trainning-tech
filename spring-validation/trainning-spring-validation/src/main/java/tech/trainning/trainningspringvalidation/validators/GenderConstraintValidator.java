package tech.trainning.trainningspringvalidation.validators;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import tech.trainning.trainningspringvalidation.enums.GenderEnum;

import java.util.Locale;
import java.util.Objects;


public class GenderConstraintValidator implements ConstraintValidator<GenderConstraint, String> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(GenderConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext constraintValidatorContext) {
        boolean isBlank = isBlank(gender);

        if (isBlank) {
            constraintValidatorContext.disableDefaultConstraintViolation();

            addViolationMessage(
                    messageSource
                            .getMessage("validation.constraints.not-blank", null, Locale.of("pt-BR")),
                    constraintValidatorContext
            );

            return Boolean.FALSE;
        }

        boolean hasFoundEnum = GenderEnum.fromKey(gender) != null;

        if (hasFoundEnum) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private void addViolationMessage(String message, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

    private boolean isBlank(String gender) {
        return Objects.isNull(gender) || gender.trim().isEmpty();
    }

}
