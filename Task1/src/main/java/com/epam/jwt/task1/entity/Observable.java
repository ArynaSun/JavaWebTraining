package com.epam.jwt.task1.entity;


public interface Observable {

    void notifyObserver();

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);


}
