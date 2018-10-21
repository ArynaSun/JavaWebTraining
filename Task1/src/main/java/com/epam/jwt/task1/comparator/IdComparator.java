package com.epam.jwt.task1.comparator;

import com.epam.jwt.task1.entity.Ball;

public class IdComparator implements BallComparator {

    @Override
    public int compare(Ball o1, Ball o2) {
        if (o1.getId() == o2.getId()) {
            return 0;
        }
        if (o1.getId() > o2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
