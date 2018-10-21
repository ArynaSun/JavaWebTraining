package com.epam.jwt.task1.action.impl;

import com.epam.jwt.task1.action.BallInfoHelper;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;
import com.epam.jwt.task1.validator.BallValidator;

public class BallInfoHelperImpl implements BallInfoHelper {

    private static BallInfoHelperImpl ballInfoHelper;

    public static BallInfoHelperImpl getBallInfoHelper() {
        if (ballInfoHelper == null) {
            ballInfoHelper = new BallInfoHelperImpl();
        }
        return ballInfoHelper;
    }

    private BallInfoHelperImpl() {
    }

    public boolean isBall(Object ball) {
        return ball instanceof Ball;
    }

    public boolean isTangentXoy(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getZ());
    }

    public boolean isTangentXoz(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getY());
    }

    public boolean isTangentYoz(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getX());
    }


}
