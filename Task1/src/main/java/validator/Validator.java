package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String VALID_STRING = "(\\d+(\\.\\d+)?(\\s+)?){4}";
    //"([0-9]\\.[0-9]\\s){3}[0-9]\\.[0-9]{1}";
    //"(\\d+(\\.\\d+)?(\\s+)?){4}";

    public static boolean validate(String input) {
        boolean isValid = input.matches(VALID_STRING);
        return isValid;
    }
}

//    public static void main(String[] args) {
//        System.out.println(validate("0.1 0.3 0.4"));
//    }
//
//}
