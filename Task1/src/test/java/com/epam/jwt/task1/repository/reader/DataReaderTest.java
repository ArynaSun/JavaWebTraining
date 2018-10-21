package com.epam.jwt.task1.repository.reader;

import com.epam.jwt.task1.exception.DataReaderException;
import com.epam.jwt.task1.repository.reader.Impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest extends Assert {
    private DataReader dataReader;

    @BeforeTest
    public void init() {
        dataReader = new DataReaderImpl("resourses/TestData.txt");
    }

    @Test
    public void readDataTest() throws DataReaderException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("6.0 8.9 0.6 8.4");

        List<String> actualList = dataReader.readData();

        assertEquals(expectedList, actualList);
    }
}
