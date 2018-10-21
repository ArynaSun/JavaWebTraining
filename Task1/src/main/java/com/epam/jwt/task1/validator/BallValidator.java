package com.epam.jwt.task1.validator;

import com.epam.jwt.task1.entity.Ball;

public interface BallValidator {

    static boolean validate(Ball ball) {
        return ball.getRadius() >= 0;
    }

}
