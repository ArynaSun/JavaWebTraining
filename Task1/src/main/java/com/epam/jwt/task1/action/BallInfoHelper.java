package com.epam.jwt.task1.action;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;

public interface BallInfoHelper {
    boolean isBall(Object ball);

    boolean isTangentXoy(Ball ball) throws ValidationException;

    boolean isTangentXoz(Ball ball) throws ValidationException;

    boolean isTangentYoz(Ball ball) throws ValidationException;

}
