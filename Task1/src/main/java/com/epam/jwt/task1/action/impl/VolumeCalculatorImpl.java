package com.epam.jwt.task1.action.impl;

import com.epam.jwt.task1.action.VolumeCalculator;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;
import com.epam.jwt.task1.validator.BallValidator;

public class VolumeCalculatorImpl implements VolumeCalculator {
    public static final double PI = Math.PI;
    private static VolumeCalculatorImpl volumeCalculator;

    public static VolumeCalculatorImpl getVolumeCalculator() {
        if (volumeCalculator == null) {
            volumeCalculator = new VolumeCalculatorImpl();
        }
        return volumeCalculator;
    }

    private VolumeCalculatorImpl() {
    }

    public double calculateBallVolume(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double ballVolume;
        ballVolume = (4.0 / 3.0) * PI * Math.pow(ball.getRadius(), 3);
        return ballVolume;
    }

    public double calculateSegmentVolume(Ball ball, double height) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double segmentVolume;
        segmentVolume = PI * Math.pow(height, 2) * (ball.getRadius() - (1.0 / 3.0) * height);
        return segmentVolume;
    }
}
