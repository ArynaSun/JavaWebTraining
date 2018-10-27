package com.epam.jwt.task2.parser;

import com.epam.jwt.task2.entity.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SentenceParser implements StringParser {

    private static final String SENTENCE_SEPARATOR = "\\.|\\.\\.\\.|\\?|\\!";

    private StringParser lexemeParser;

    public SentenceParser(StringParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    public List<List<String>> parseSentence(List<String> paragraphs) {
        List<List<String>> sentencesFromText = new ArrayList<>();

        for (int i = 0; i < paragraphs.size(); i++) {
            List<String> sentencesFromParagraph = Arrays.asList(paragraphs.get(i).split(SENTENCE_SEPARATOR));
            sentencesFromText.add(sentencesFromParagraph);
        }

        return sentencesFromText;
    }

    @Override
    public Text parseData(Object text) {
        return lexemeParser.parseData(parseSentence((List<String>) text));
    }
}
