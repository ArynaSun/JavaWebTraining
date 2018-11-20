package com.epam.jwt.task4.entitty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.concurrent.Callable;

public abstract class Vehicle implements Callable<Void>, Serializable{

    private static Logger logger = LogManager.getLogger(Vehicle.class);

    private int weight;
    private int square;

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
    public Void call(){
        RiverFerry ferry = RiverFerry.getInstance();
        try {
            ferry.getSemaphore().acquire();
            ferry.operate(this);
            ferry.getSemaphore().release();
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
        return null;
    }
}
