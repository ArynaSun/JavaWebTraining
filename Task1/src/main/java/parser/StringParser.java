package parser;

import entity.Ball;
import entity.Point;
import validator.Validator;

public class StringParser {

    private static final String REGEX = "\\s+";

    public static Ball parseString(String line) {//////////comment
        String[] strings = line.split(REGEX);
        if (Validator.validate(strings)) {
            return new Ball(
                    Double.parseDouble(strings[0]),
                    new Point(
                            Double.parseDouble(strings[1]),
                            Double.parseDouble(strings[2]),
                            Double.parseDouble(strings[3])
                    )
            );
        }
        return new Ball();
    }
}