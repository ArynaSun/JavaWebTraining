package com.epam.jwt.task1.entity;

import com.epam.jwt.task1.exception.ValidationException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ball implements Serializable, Observable {

    private final int id;
    private double radius;
    private Point center;

    private List<Observer> observers = new ArrayList<>();

    public Ball(int id) {
        this.id = id;
        center = new Point();
    }

    public Ball(int id, double radius, Point center) {
        this.id = id;
        this.radius = radius;
        this.center = center;

    }

    public int getId(){return id;}

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Ball object = (Ball) obj;

        if (object.radius != this.radius) {
            return false;
        }

        if (!object.center.equals(this.center)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int intRadius = (int) this.radius;
        int hashOfCenter = center.hashCode();

        return 17 * intRadius + 13 * hashOfCenter;
    }

    @Override
    public String toString() {
        return radius + " " + center.toString();
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i<observers.size(); i++) {
            try {
                observers.get(i).update(this);
            } catch (ValidationException e) {
                //Этот метод не должен завершить работу
                //Если вылетит исключение, но обработать его
                //не может (SRP)
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerObserver(Observer obsrver) {
        observers.add(obsrver);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }
}

