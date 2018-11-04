package comparator;

import com.epam.jwt.task2.comparator.LexemeByCharacterEntryComparator;
import com.epam.jwt.task2.entity.Lexeme;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeByCharacterEntryComparatorTest extends Assert {

    private LexemeByCharacterEntryComparator lexemeByCharacterEntryComparator;

    @BeforeTest
    public void init() {
        lexemeByCharacterEntryComparator = new LexemeByCharacterEntryComparator();
    }

    @Test
    public void countSymbolsInTest() {
        char[] symbols = new char[]{'h', 'e', 'l', 'l', 'o'};
        char symbol = 'l';
        int expectedCount = 2;
        lexemeByCharacterEntryComparator.setSymbol(symbol);

        int actualCount = lexemeByCharacterEntryComparator.countSymbolsIn(symbols);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void compareTest() {
        Lexeme lexeme1 = new Lexeme("Hello");
        Lexeme lexeme2 = new Lexeme("World");
        char symbol = 'l';
        lexemeByCharacterEntryComparator.setSymbol(symbol);
        int expectedCount = 1;

        int actualCount = lexemeByCharacterEntryComparator.compare(lexeme1, lexeme2);

        assertEquals(expectedCount, actualCount);

    }

}
