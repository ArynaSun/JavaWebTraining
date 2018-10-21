package com.epam.jwt.task1.comparator;

import com.epam.jwt.task1.action.impl.SquareCalculatorImpl;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;

public class SquareComparator {
//        implements BallComparator {
//
//    @Override
//    public int compare(Ball o1, Ball o2) {
//        double square1 = 0, square2 = 0;
//        try {
//            square1 = SquareCalculatorImpl.getSquareCalculator().calculateBallSquare(o1);
//            square2 = SquareCalculatorImpl.getSquareCalculator().calculateBallSquare(o2);
//        } catch (ValidationException e) {
//            e.printStackTrace();
//        }
//        if (square1 == square2) {
//            return 0;
//        }
//        if (square1 > square2) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
}
