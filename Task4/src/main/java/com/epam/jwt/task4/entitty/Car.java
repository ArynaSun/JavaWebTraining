package com.epam.jwt.task4.entitty;

import com.epam.jwt.task4.reader.DataReader;
import com.epam.jwt.task4.reader.Impl.DataReaderImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Car extends Vehicle {

    private static final int CAR_WEIGHT;
    private static final int CAR_SQUARE;

    static {
        DataReader reader = DataReaderImpl.getInstance();
        CAR_WEIGHT = reader.readCarWeight();
        CAR_SQUARE = reader.readCarSquare();
    }

    public Car() {
        super(CAR_WEIGHT, CAR_SQUARE);
    }


}
