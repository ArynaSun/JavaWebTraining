package repository.specification;

import action.SquareCalculator;
import entity.Ball;
import exception.ValidationException;

public class BySquareSpec implements BallSpecification {//TODO

    private SquareCalculator squareCalculator = new SquareCalculator();
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
