package com.epam.jwt.task1.specification.impl;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.specification.BallSpecification;

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
