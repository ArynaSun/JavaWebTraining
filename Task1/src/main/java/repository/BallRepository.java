package repository;

import entity.Ball;
import repository.specification.BallSpecification;

import java.util.List;

public interface BallRepository {

    void create(Ball ball);

    void update(Ball ball);

    void delete(Ball ball);

    List<Ball> findBy(BallSpecification ballSpecification);
}
