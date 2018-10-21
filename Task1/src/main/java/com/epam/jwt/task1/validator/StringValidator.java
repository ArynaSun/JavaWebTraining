package com.epam.jwt.task1.validator;

public interface StringValidator {
    String VALID_STRING = "(\\d+(\\.\\d+)?(\\s+)?){5}";

    static boolean validate(String input) {
        boolean isValid = input.matches(VALID_STRING);
        return isValid;
    }

}





