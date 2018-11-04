package com.epam.jwt.task1.repository.parser;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.entity.Point;
import com.epam.jwt.task1.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public interface StringParser {

    String REGEX_SEPARATOR = "\\s+";
    int X_INDEX = 1;
    int Y_INDEX = 2;
    int Z_INDEX = 3;
    int ID_INDEX = 4;
    int RADIUS_INDEX = 0;

    static List<Ball> parseBall(List<String> lines) {
        List<Ball> balls = new ArrayList<>();
        deleteNotValidLines(lines);
        for (String line : lines) {


            String[] strings = line.split(REGEX_SEPARATOR);

            Point centralPoint = new Point(
                    Double.parseDouble(strings[X_INDEX]),
                    Double.parseDouble(strings[Y_INDEX]),
                    Double.parseDouble(strings[Z_INDEX])
            );

            int id = (int) Double.parseDouble(strings[ID_INDEX]);
            double radius = Double.parseDouble(strings[RADIUS_INDEX]);
            Ball ball = new Ball(id, radius, centralPoint);

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