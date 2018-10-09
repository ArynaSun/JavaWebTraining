package reader;

import exception.DataReaderException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest extends Assert {
    private DataReader dataReader;

    @BeforeTest
    public void init() {
        dataReader = new DataReader();
    }

    @Test
    public void readDataTest() throws DataReaderException {
        String fileName = "src/main/resources/TestData.txt";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("6.0 8.9 0.6 8.4");

        List<String> actualList = dataReader.readData(fileName);

        assertEquals(expectedList, actualList);
    }
}
