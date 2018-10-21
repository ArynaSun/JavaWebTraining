package com.epam.jwt.task1.action.impl;

import com.epam.jwt.task1.action.SquareCalculator;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;
import com.epam.jwt.task1.validator.BallValidator;

public class SquareCalculatorImpl implements SquareCalculator{
    private static final double PI = Math.PI;
    private static SquareCalculatorImpl squareCalculator;

    public static SquareCalculatorImpl getSquareCalculator(){
        if(squareCalculator == null){
            squareCalculator = new SquareCalculatorImpl();
        }
        return squareCalculator;
    }

    private SquareCalculatorImpl(){}

    public double calculateBallSquare(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double ballSquare;
        ballSquare = 4 * PI * Math.pow(ball.getRadius(), 2);
        return ballSquare;
    }
}
