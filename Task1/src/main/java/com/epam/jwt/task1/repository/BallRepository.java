package com.epam.jwt.task1.repository;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.specification.BallSpecification;

import java.util.List;

public interface BallRepository {

    void create(Ball ball);

    void update(Ball ball);

    void delete(Ball ball);

    List<Ball> findBy(BallSpecification ballSpecification);
}
