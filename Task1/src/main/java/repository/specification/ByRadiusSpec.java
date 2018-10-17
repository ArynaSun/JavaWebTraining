package repository.specification;

import entity.Ball;

public class ByRadiusSpec implements BallSpecification {

    private double radius;

    public ByRadiusSpec(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean isFit(Ball ball) {
        return ball.getRadius() == radius;
    }
}
