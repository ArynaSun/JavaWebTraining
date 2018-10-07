package action;

import entity.Ball;
import entity.Point;
import exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class SquareCalculatorTest extends Assert {

    private SquareCalculator calculator;

    @BeforeTest
    public void init() {
        calculator = new SquareCalculator();
    }

    @Test
    public void calculateBallSquareTest() throws ValidationException {
        Ball ball = new Ball(5, new Point(0, 0, 0));
        double expectedSquare = 4 * PI * Math.pow(ball.getRadius(), 2);

        double actualSquare = calculator.calculateBallSquare(ball);

        assertEquals(expectedSquare, actualSquare);
    }

}
