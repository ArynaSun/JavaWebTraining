package com.epam.jwt.task1.action;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;

public interface VolumeCalculator {

    double calculateBallVolume(Ball ball) throws ValidationException;

    double calculateSegmentVolume(Ball ball, double height) throws ValidationException;
}
