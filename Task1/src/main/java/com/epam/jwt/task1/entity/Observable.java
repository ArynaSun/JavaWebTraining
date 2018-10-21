package com.epam.jwt.task1.entity;


public interface Observable {

    void notifyObserver();

    void registerObserver(Observer obsrver);

    void unregisterObserver(Observer observer);


}
