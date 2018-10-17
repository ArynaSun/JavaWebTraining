package repository.specification;

import entity.Ball;

public class ByIdSpec implements BallSpecification {

    private int id;

    public ByIdSpec(int id) {
        this.id = id;
    }

    @Override
    public boolean isFit(Ball ball) {
        return ball.getId() == id;
    }
}
