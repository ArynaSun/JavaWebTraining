package com.epam.jwt.task4.entitty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.concurrent.Callable;

public abstract class Vehicle implements Callable<Void>, Serializable {

    private static Logger logger = LogManager.getLogger(Vehicle.class);

    protected int weight;
    protected int square;

    public Vehicle(int weight, int square) {
        this.weight = weight;
        this.square = square;
    }

    public int getWeight() {
        return weight;
    }

    public int getSquare() {
        return square;
    }

    public void setWeight(int carWeight) {
        this.weight = carWeight;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public Void call() {
        RiverFerry ferry = RiverFerry.getInstance();
        try {
            ferry.getSemaphore().acquire();
            ferry.operate(this);
            ferry.getSemaphore().release();
        } catch (InterruptedException e) {
            logger.info("Ошибка семафора при взятии ресурса");
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Vehicle vehicle = (Vehicle) obj;
        if (weight != vehicle.weight) {
            return false;
        }
        if (square != vehicle.square) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return weight * 31 + square * 11;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "weight: " + weight + ", square: " + square;
    }
}
