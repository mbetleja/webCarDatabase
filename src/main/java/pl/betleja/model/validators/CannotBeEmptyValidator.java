package pl.betleja.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CannotBeEmptyValidator implements ConstraintValidator<CannotBeEmpty, Object> {

    @Override
    public void initialize(CannotBeEmpty constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        return obj != null;
    }
}
