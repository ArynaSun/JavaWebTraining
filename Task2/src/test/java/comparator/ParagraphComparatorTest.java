package comparator;

import com.epam.jwt.task2.comparator.ParagraphComparator;
import com.epam.jwt.task2.entity.Paragraph;
import com.epam.jwt.task2.entity.Sentence;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParagraphComparatorTest extends Assert {

    private ParagraphComparator paragraphComparator;

    @BeforeTest
    public void init() {
        paragraphComparator = new ParagraphComparator();
    }

    @Test
    public void compareTest() {

        Paragraph paragraph1 = new Paragraph();
        Paragraph paragraph2 = new Paragraph();
        initParagraphs(paragraph1, paragraph2);
        int expected = 1;

        int actual = paragraphComparator.compare(paragraph1, paragraph2);

        assertEquals(expected, actual);

    }

    private void initParagraphs(Paragraph paragraph1, Paragraph paragraph2) {
        List<Sentence> sentences1 = new ArrayList<>();

        sentences1.add(new Sentence());
        sentences1.add(new Sentence());
        sentences1.add(new Sentence());

        paragraph1.setSentenceList(sentences1);

        List<Sentence> sentences2 = new ArrayList<>();

        sentences2.add(new Sentence());
        sentences2.add(new Sentence());

        paragraph2.setSentenceList(sentences2);
    }


}
