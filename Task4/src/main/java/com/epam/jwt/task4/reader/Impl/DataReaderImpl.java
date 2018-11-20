package com.epam.jwt.task4.reader.Impl;

import com.epam.jwt.task4.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {


    protected static final String FILE_NAME = "resources/Data.txt";

    private static final int CAR_SQUARE_INDEX = 0;
    private static final int CAR_WEIGHT_INDEX = 1;
    private static final int TRUCK_SQUARE_INDEX = 2;
    private static final int TRUCK_WEIGHT_INDEX = 3;
    private static Logger logger = LogManager.getLogger(DataReaderImpl.class);

    private int carSquare;
    private int carWeight;
    private int truckSquare;
    private int truckWeight;

    private DataReaderImpl(String fileName){
        List<String> data = readData(fileName);
        carSquare = Integer.parseInt(data.get(CAR_SQUARE_INDEX));
        carWeight = Integer.parseInt(data.get(CAR_WEIGHT_INDEX));
        truckSquare = Integer.parseInt(data.get(TRUCK_SQUARE_INDEX));
        truckWeight = Integer.parseInt(data.get(TRUCK_WEIGHT_INDEX));
    }

    private static class DataReaderImplHelper{
        private static final DataReaderImpl INSTANCE = new DataReaderImpl(FILE_NAME);
    }

    public static DataReaderImpl getInstance(){
        return DataReaderImplHelper.INSTANCE;
    }

    private List<String> readData(String fileName) {
        List<String> dataLines;
        Path path = Paths.get(fileName);

        try (Stream<String> lineStream = Files.lines(path)) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal("Error while opening file: " + fileName + e);
            throw new RuntimeException("Error while opening file", e);
        }
        return dataLines;
    }

    @Override
    public int readCarWeight() {
        return carWeight;
    }

    @Override
    public int readCarSquare() {
        return carSquare;
    }

    @Override
    public int readTruckWeight() {
        return truckWeight;
    }

    @Override
    public int readTruckSquare() {
        return truckSquare;
    }
}
