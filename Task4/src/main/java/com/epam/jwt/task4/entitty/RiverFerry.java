package com.epam.jwt.task4.entitty;

import java.io.Serializable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RiverFerry implements Serializable {

    private static final int PERMITS = 1;
    private static final int platformSquare = 80;
    private static final int carryingCapacity = 160000;
    private static final int TRANSPORTATION_TIME = 5;
    private static final int EMPTY_FERRY_WEIGHT = 0;
    private static final int EMPTY_FERRY_SQUARE = 0;

    private AtomicInteger occupiedSquare;
    private AtomicInteger currentWeightOfVehicles;
    private Semaphore semaphore;

    private RiverFerry() {
        semaphore = new Semaphore(PERMITS);
        occupiedSquare = new AtomicInteger(EMPTY_FERRY_SQUARE);
        currentWeightOfVehicles = new AtomicInteger(EMPTY_FERRY_WEIGHT);
    }

    private static class RiverFerryHelper {
        private static final RiverFerry INSTANCE = new RiverFerry();
    }

    public static RiverFerry getInstance() {
        return RiverFerryHelper.INSTANCE;
    }

    public int getOccupiedSquare() {
        return occupiedSquare.intValue();
    }

    public void setOccupiedSquare(int occupiedSquare) {
        this.occupiedSquare = new AtomicInteger(occupiedSquare);
    }

    public int getCurrentWeightOfVehicles() {
        return currentWeightOfVehicles.intValue();
    }

    public void setCurrentWeightOfVehicles(int currentWeightOfVehicles) {
        this.currentWeightOfVehicles = new AtomicInteger(currentWeightOfVehicles);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void operate(Vehicle vehicle) {
        if (isFit(vehicle)) {
            System.out.println(vehicle.getClass().getSimpleName() + " called on the way");
            currentWeightOfVehicles.getAndAdd(vehicle.getWeight());
            occupiedSquare.getAndAdd(vehicle.getSquare());
            System.out.println(occupiedSquare.intValue() + " " + currentWeightOfVehicles.intValue());
            return;
        } else {
            transport();
            operate(vehicle);
        }

    }

    private void transport() {
        System.out.println("Ferry is transporting " + occupiedSquare.intValue() + ", " + currentWeightOfVehicles.intValue());
        try {
            TimeUnit.SECONDS.sleep(TRANSPORTATION_TIME);
            currentWeightOfVehicles.set(EMPTY_FERRY_WEIGHT);
            occupiedSquare.set(EMPTY_FERRY_SQUARE);
            TimeUnit.SECONDS.sleep(TRANSPORTATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isFit(Vehicle vehicle) {
        return (vehicle.getWeight() + currentWeightOfVehicles.intValue()) <= carryingCapacity
                && (vehicle.getSquare() + occupiedSquare.intValue()) <= platformSquare;
    }

//    @Override
//    public boolean equals(Object obj){return true;}
//
//    @Override
//    public int hashCode(){
//        return
//    }
//
//    @Override
//    public String toString(){
//        return getClass().getName() ;
//    }
}
