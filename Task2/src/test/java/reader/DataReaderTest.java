package reader;

import com.epam.jwt.task2.reader.DataReader;
import com.epam.jwt.task2.reader.impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReaderTest extends Assert {

    private DataReader dataReader;

    @BeforeTest
    public void init(){
        dataReader = new DataReaderImpl("resources/testData.txt");
    }

    @Test
    public void readData(){
        String expectedData = "Hello World!\n";

        String actualData = dataReader.readData();

        assertEquals(expectedData, actualData);
    }
}
