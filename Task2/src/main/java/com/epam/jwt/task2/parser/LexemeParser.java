package com.epam.jwt.task2.parser;

import com.epam.jwt.task2.entity.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LexemeParser implements StringParser {

    private static final String LEXEME_SEPARATOR = "\\s";

    private StringParser textParser;

    public LexemeParser(StringParser textParser) {
        this.textParser = textParser;
    }

    public List<List<List<String>>> parseLexeme(List<List<String>> sentencesFromText) {
        List<List<List<String>>> lexemeFromText = new ArrayList<>();

        for (int i = 0; i < sentencesFromText.size(); i++) {
            List<List<String>> lexemeFromParagraph = new ArrayList<>();

            for (int j = 0; j < sentencesFromText.get(i).size(); j++) {
                List<String> lexemeFromSentences = Arrays.asList(sentencesFromText.get(i).get(j).split(LEXEME_SEPARATOR));
                lexemeFromParagraph.add(lexemeFromSentences);
            }
            lexemeFromText.add(lexemeFromParagraph);
        }
        return lexemeFromText;
    }

    @Override
    public Text parseData(Object text) {
        return textParser.parseData(parseLexeme((List<List<String>>) text));
    }
}
