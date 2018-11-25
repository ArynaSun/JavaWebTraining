package com.epam.jwt.task4.entitty;

import com.epam.jwt.task4.reader.DataReader;
import com.epam.jwt.task4.reader.Impl.DataReaderImpl;

public class Truck extends Vehicle {

    private static final int TRUCK_WEIGHT;
    private static final int TRUCK_SQUARE;

    static {
        DataReader reader = DataReaderImpl.getInstance();
        TRUCK_WEIGHT = reader.readTruckWeight();
        TRUCK_SQUARE = reader.readTruckSquare();
    }

    public Truck() {
        super(TRUCK_WEIGHT, TRUCK_SQUARE);
    }
}
