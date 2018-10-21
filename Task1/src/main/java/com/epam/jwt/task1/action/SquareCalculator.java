package com.epam.jwt.task1.action;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;

public interface SquareCalculator  {
    double calculateBallSquare(Ball ball) throws ValidationException;
}
