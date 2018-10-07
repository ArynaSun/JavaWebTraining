package validator;

import entity.Ball;

public class BallValidator {
    public static boolean validate(Ball ball) {
        return ball.getRadius() >= 0;
    }

}
