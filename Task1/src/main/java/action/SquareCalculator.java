package action;

import entity.Ball;
import exception.ValidationException;
import validator.BallValidator;

public class SquareCalculator {
    private static final double PI = Math.PI;

    public double calculateBallSquare(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double ballSquare;
        ballSquare = 4 * PI * Math.pow(ball.getRadius(), 2);
        return ballSquare;
    }
}
