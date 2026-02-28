package tech.trainning.trainningspringvalidation.validators;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import tech.trainning.trainningspringvalidation.enums.GenderEnum;

import java.util.Arrays;
import java.util.List;


public class GenderEnumConstraintValidator implements ConstraintValidator<GenderEnumConstraint, GenderEnum> {

    private final List<GenderEnum> acceptedEnums = Arrays.stream(GenderEnum.values()).toList();

    @Override
    public void initialize(GenderEnumConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(GenderEnum gender, ConstraintValidatorContext constraintValidatorContext) {
        boolean hasFoundEnum = acceptedEnums.stream().anyMatch(g -> g.equals(gender));

        if (hasFoundEnum) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
