package parser;

import com.epam.jwt.task2.parser.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SentenceParserTest extends Assert {

    private SentenceParser sentenceParser;

    @BeforeTest
    public void init() {
        sentenceParser = new SentenceParser(null);
    }

    @Test
    public void parseSentenceTest() {
        List<String> data = new ArrayList<>();
        data.add("Hello!World!");
        int expectedCountOfSentences = 2;

        int actualCountOfSentences = sentenceParser.parseSentence(data).get(0).size();

        assertEquals(expectedCountOfSentences, actualCountOfSentences);

    }
}
