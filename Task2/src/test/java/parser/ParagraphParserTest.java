package parser;

import com.epam.jwt.task2.parser.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphParserTest extends Assert {

    private ParagraphParser paragraphParser;

    @BeforeTest
    public void init() {
        paragraphParser = new ParagraphParser(null);
    }

    @Test
    public void parseParagraphTest() {
        String data = "Hello\nWorld!";
        int expectedListSize = 2;

        int actualListSize = paragraphParser.parseParagraph(data).size();

        assertEquals(expectedListSize, actualListSize);
    }
}
