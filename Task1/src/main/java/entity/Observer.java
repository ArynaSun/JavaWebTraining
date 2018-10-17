package entity;

import exception.ValidationException;

public interface Observer {

    void update(Ball ball) throws ValidationException;
}
