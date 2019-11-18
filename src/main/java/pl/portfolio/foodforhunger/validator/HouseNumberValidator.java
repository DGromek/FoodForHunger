package pl.portfolio.foodforhunger.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HouseNumberValidator implements ConstraintValidator<HouseNumber, String> {

    @Override
    public boolean isValid(String houseNumber, ConstraintValidatorContext context) {
        return houseNumber.matches("\\d\\d[a-zA-Z]?");
    }
}
