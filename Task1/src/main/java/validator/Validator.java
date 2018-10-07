package validator;

public class Validator {
    private static final String VALID_STRING = "(\\d+(\\.\\d+)?(\\s+)?){4}";

    public static boolean validate(String input) {
        boolean isValid = input.matches(VALID_STRING);
        return isValid;
    }

}





