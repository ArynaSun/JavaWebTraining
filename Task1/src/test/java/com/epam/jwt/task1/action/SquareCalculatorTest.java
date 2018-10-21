package com.epam.jwt.task1.action;

import com.epam.jwt.task1.action.impl.SquareCalculatorImpl;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.entity.Point;
import com.epam.jwt.task1.exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class SquareCalculatorTest extends Assert {

    private SquareCalculator calculator;

    @BeforeTest
    public void init() {
        calculator = SquareCalculatorImpl.getSquareCalculator();
    }

    @Test
    public void calculateBallSquareTest() throws ValidationException {
        Ball ball = new Ball(0, 5, new Point(0, 0, 0));
        double expectedSquare = 4 * PI * Math.pow(ball.getRadius(), 2);

        double actualSquare = calculator.calculateBallSquare(ball);

        assertEquals(expectedSquare, actualSquare);
    }

}
