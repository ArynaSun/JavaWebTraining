package com.epam.jwt.task4.test.reader;

import com.epam.jwt.task4.reader.DataReader;
import com.epam.jwt.task4.reader.Impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReaderTest extends Assert {
    private DataReader dataReader;

    @BeforeTest
    public void init(){
        dataReader =DataReaderImpl.getInstance();
    }

    @Test
    public void readCarSquare(){
        int carSquare = 3;

        assertEquals(dataReader.readCarSquare(), carSquare);
    }

    @Test
    public void readCarWeight(){
        int carWeight = 2100;

        assertEquals(dataReader.readCarWeight(), carWeight);
    }

    @Test
    public void readTruckSquare(){
        int truckSquare = 7;

        assertEquals(dataReader.readTruckSquare(), truckSquare);
    }

    @Test
    public void readTruckWeight(){
        int truckWeight = 8000;

        assertEquals(dataReader.readTruckWeight(), truckWeight);
    }

}
