package com.petproposal.petproposal.validation;

import java.util.function.IntPredicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password contactNumber) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value != null && value.length() >= 7 && containsUpperCase(value) && containsNumber(value)
                && containsSpecialChar(value);
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private boolean containsSpecialChar(String value) {
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";

        for (Character c : value.toCharArray()) {
            if (specialChars.contains(c.toString())) {
                return false;
            }
        }
        return true;
    }

}
