package com.epam.jwt.task1.specification.impl;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.specification.BallSpecification;

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
