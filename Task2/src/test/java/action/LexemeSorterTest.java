package action;

import com.epam.jwt.task2.action.Impl.LexemeSorterImpl;
import com.epam.jwt.task2.action.LexemeSorter;
import com.epam.jwt.task2.entity.Lexeme;
import com.epam.jwt.task2.entity.Paragraph;
import com.epam.jwt.task2.entity.Sentence;
import com.epam.jwt.task2.entity.Text;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LexemeSorterTest extends Assert {

    private LexemeSorter lexemeSorter;

    @BeforeTest
    public void init() {
        lexemeSorter = new LexemeSorterImpl();
    }

    @Test
    public void sortByLengthTest() {
        List<String> words = new ArrayList<>();
        words.add("World!");
        words.add("Hello");

        Text text = initText(words);

        lexemeSorter.sortByLength(text);
        String s = text.convertPartOfTextToString();

        assertEquals(s, "\tHello\\sWorld!\\s\n");
    }

    private Text initText(List<String> words) {
        Text text = new Text();
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();

        List<Lexeme> lexemes = new ArrayList<>();
        for (String word : words) {
            lexemes.add(new Lexeme(word));
        }

        sentence.setLexemeList(lexemes);

        List<Sentence> sentences = new ArrayList<>();

        sentences.add(sentence);

        paragraph.setSentenceList(sentences);

        List<Paragraph> paragraphs = new ArrayList<>();

        paragraphs.add(paragraph);

        text.setParagraphList(paragraphs);

        return text;
    }

    @Test
    public void sortByCharacterEntryTest() {
        List<String> words = new ArrayList<>();

        words.add("Helloooooo");
        words.add("World!");


        Text text = initText(words);

        char symbol = 'o';

        lexemeSorter.sortByCharacterEntry(symbol, text);
        String s = text.convertPartOfTextToString();

        assertEquals(s, "\tWorld!\\sHelloooooo\\s\n");

    }


}
