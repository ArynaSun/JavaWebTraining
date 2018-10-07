package action;

import entity.Ball;
import entity.Point;
import exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class VolumeCalculatorTest extends Assert {

    private VolumeCalculator calculator;

    @BeforeTest
    public void init() {
        calculator = new VolumeCalculator();
    }

    @Test
    public void calculateBallVolumeTest() throws ValidationException {
        Ball ball = new Ball(5, new Point(0, 0, 0));
        double expectedBallVolume = (4.0 / 3.0) * PI * Math.pow(ball.getRadius(), 3);

        double actualBallVolume = calculator.calculateBallVolume(ball);

        assertEquals(expectedBallVolume, actualBallVolume);
    }

    @Test
    public void calculateSegmentVolumeTest() throws ValidationException {
        Ball ball = new Ball(5, new Point(0, 0, 0));
        double height = 2;
        double expectedSegmentVolume = PI * Math.pow(height, 2) * (ball.getRadius() - (1.0 / 3.0) * height);

        double actualSegmentVolume = calculator.calculateSegmentVolume(ball, height);

        assertEquals(expectedSegmentVolume, actualSegmentVolume);
    }
}
