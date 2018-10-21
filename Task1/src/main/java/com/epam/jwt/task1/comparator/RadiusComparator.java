package com.epam.jwt.task1.comparator;

import com.epam.jwt.task1.entity.Ball;

public class RadiusComparator implements BallComparator {
    @Override
    public int compare(Ball o1, Ball o2) {
        if (o1.getRadius() == o2.getRadius()) {
            return 0;
        }
        if (o1.getRadius() > o2.getRadius()) {
            return 1;
        } else {
            return -1;
        }
    }
}
