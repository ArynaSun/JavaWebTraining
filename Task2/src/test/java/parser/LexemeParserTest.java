package parser;

import com.epam.jwt.task2.parser.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LexemeParserTest extends Assert {

    private LexemeParser lexemeParser;

    @BeforeTest
    public void init() {
        lexemeParser = new LexemeParser(null);
    }

    @Test
    public void parseLexemeTest() {
        List<List<String>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.get(0).add("Hello World");
        int expectedCountOfWords = 2;

        int actualCountOfWords = lexemeParser.parseLexeme(data).get(0).get(0).size();

        assertEquals(expectedCountOfWords, actualCountOfWords);
    }
}
