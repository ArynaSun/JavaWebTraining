package com.epam.jwt.task1.specification.impl;

import com.epam.jwt.task1.action.impl.SquareCalculatorImpl;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;
import com.epam.jwt.task1.specification.BallSpecification;

public class BySquareSpec implements BallSpecification {//TODO

    private SquareCalculatorImpl squareCalculator = SquareCalculatorImpl.getSquareCalculator();
    private double ballSquare;

    public BySquareSpec(double ballSquare) {
        this.ballSquare = ballSquare;
    }

    @Override
    public boolean isFit(Ball ball) {
        try {
            return ballSquare == squareCalculator.calculateBallSquare(ball);
        } catch (ValidationException e) {
            return false;
        }
    }
}
