package com.epam.jwt.task1.entity;

import com.epam.jwt.task1.exception.ValidationException;

public interface Observer {

    void update(Ball ball) throws ValidationException;
}
