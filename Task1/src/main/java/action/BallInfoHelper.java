package action;

import entity.Ball;
import exception.ValidationException;
import validator.BallValidator;

public class BallInfoHelper {

    public boolean isBall(Object ball) {
        return ball instanceof Ball;
    }

    public boolean isTangentXoy(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getZ());
    }

    public boolean isTangentXoz(Ball ball)throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getY());
    }

    public boolean isTangentYoz(Ball ball) throws ValidationException{
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        return ball.getRadius() == Math.abs(ball.getCenter().getX());
    }


}
