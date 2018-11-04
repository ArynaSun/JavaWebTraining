package action;

import com.epam.jwt.task2.action.Impl.ParagraphSorterImpl;
import com.epam.jwt.task2.action.ParagraphSorter;
import com.epam.jwt.task2.entity.Paragraph;
import com.epam.jwt.task2.entity.Sentence;
import com.epam.jwt.task2.entity.Text;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterTest extends Assert {

    ParagraphSorter paragraphSorter;

    @BeforeTest
    public void init() {
        paragraphSorter = new ParagraphSorterImpl();
    }

    @Test
    public void sortTest() {
        Text text = new Text();

        List<Paragraph> paragraphs = new ArrayList<>();

        Paragraph paragraph1 = new Paragraph();
        Paragraph paragraph2 = new Paragraph();

        List<Sentence> sentences1 = new ArrayList<>();

        sentences1.add(new Sentence());
        sentences1.add(new Sentence());
        sentences1.add(new Sentence());

        paragraph1.setSentenceList(sentences1);

        List<Sentence> sentences2 = new ArrayList<>();

        sentences2.add(new Sentence());
        sentences2.add(new Sentence());

        paragraph2.setSentenceList(sentences2);

        paragraphs.add(paragraph1);
        paragraphs.add(paragraph2);

        text.setParagraphList(paragraphs);

        paragraphSorter.sort(text);

        assertEquals(text.getParagraphList().get(0), paragraph2);
    }


}
