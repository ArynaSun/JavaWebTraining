package com.epam.jwt.task1.repository.parser;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.entity.Point;
import com.epam.jwt.task1.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public interface StringParser {

    String REGEX_SEPARATOR = "\\s+";

    static List<Ball> parseBall(List<String> lines) {
        List<Ball> balls = new ArrayList<>();
        deleteNotValidLines(lines);
        for (String line : lines) {


            String[] strings = line.split(REGEX_SEPARATOR);

            Point centralPoint = new Point(
                    Double.parseDouble(strings[1]),
                    Double.parseDouble(strings[2]),
                    Double.parseDouble(strings[3])
            );

            Ball ball = new Ball(
                    (int) Double.parseDouble(strings[4]), Double.parseDouble(strings[0]),
                    centralPoint
            );

            balls.add(ball);
        }

        return balls;
    }

    static List<String> deleteNotValidLines(List<String> lines) {
        List<String> listOfItemsToRemove = new ArrayList<>();
        for (String line : lines) {
            if (!StringValidator.validate(line)) {
                listOfItemsToRemove.add(line);
            }
        }
        lines.removeAll(listOfItemsToRemove);
        return lines;
    }


}