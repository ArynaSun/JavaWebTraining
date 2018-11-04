package parser;

import com.epam.jwt.task2.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TextParserTest extends Assert {

    private TextParser textParser;

    @BeforeTest
    public void init() {
        textParser = new TextParser();
    }

    @Test
    public void parsDataTest() {
        List<List<List<String>>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.get(0).add(new ArrayList<>());
        data.get(0).get(0).add("Hello");
        data.get(0).get(0).add("World");
        int expectedCountOfWords = 2;

        int actualCountOfWords =
                textParser.parseText(data).getParagraphList().get(0).getSentenceList().get(0).getLexemeList().size();

        assertEquals(expectedCountOfWords, actualCountOfWords);

    }
}