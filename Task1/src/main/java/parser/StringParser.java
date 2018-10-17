package parser;

import entity.Ball;
import entity.Point;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private static final String REGEX_SEPARATOR = "\\s+";

    public static List<Ball> parseBall(List<String> lines) {
        List<Ball> balls = new ArrayList<>();
        for (String line : lines) {

            if (Validator.validate(line)) {

                String[] strings = line.split(REGEX_SEPARATOR);

                Point centralPoint = new Point(
                        Double.parseDouble(strings[1]),
                        Double.parseDouble(strings[2]),
                        Double.parseDouble(strings[3])
                );

                Ball ball = new Ball(
                        id, Double.parseDouble(strings[0]),
                        centralPoint
                );

                balls.add(ball);
            }
        }

        return balls;
    }
}