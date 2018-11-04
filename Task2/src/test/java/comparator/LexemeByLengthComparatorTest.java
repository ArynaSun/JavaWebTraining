package comparator;

import com.epam.jwt.task2.comparator.LexemeByLengthComparator;
import com.epam.jwt.task2.entity.Lexeme;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeByLengthComparatorTest extends Assert {

    private LexemeByLengthComparator lexemeByLengthComparator;

    @BeforeTest
    public void init() {
        lexemeByLengthComparator = new LexemeByLengthComparator();
    }

    @Test
    public void compareTest() {
        Lexeme lexeme1 = new Lexeme("Hello");
        Lexeme lexeme2 = new Lexeme("Bear");
        int expected = 1;

        int actual = lexemeByLengthComparator.compare(lexeme1, lexeme2);

        assertEquals(expected, actual);
    }
}
