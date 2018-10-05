package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String PATTERN = "[0-9.]{3}";

    private static boolean validate(String input) {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(input);
        return !(m.find() && m.group() != null && !m.group().isEmpty());
    }

    public static boolean validate(String[] input) {
        for (String s : input) {
            if (!validate(s)){
                return false;
            }
        }
        return true;
    }
}
