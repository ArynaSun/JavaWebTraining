package repository;

import entity.Ball;
import repository.specification.BallSpecification;

import java.util.ArrayList;
import java.util.List;

public class FileBallRepositoryImpl implements BallRepository {

    private List<Ball> ballList;

    @Override
    public void create(Ball ball) {

    }

    @Override
    public void update(Ball ball) {

    }

    @Override
    public void delete(Ball ball) {

    }

    @Override
    public List<Ball> findBy(BallSpecification ballSpecification) {
        List<Ball> isFitBySpecBallList = new ArrayList<>();
        for (Ball ball : ballList) {
            if (ballSpecification.isFit(ball)){
                isFitBySpecBallList.add(ball);
            }
        }
        return isFitBySpecBallList;
    }
}
