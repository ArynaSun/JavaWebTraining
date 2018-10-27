package com.epam.jwt.task2.parser;

import com.epam.jwt.task2.entity.Text;

import java.util.Arrays;
import java.util.List;

class ParagraphParser implements StringParser{

    private static final String PARAGRAPH_SEPARATOR = "\n";

    private StringParser sentenceParser;

    public ParagraphParser(StringParser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    public List<String> parseParagraph(String text){
        return Arrays.asList(text.trim().split(PARAGRAPH_SEPARATOR));
    }

    @Override
    public Text parseData(Object text) {
        return sentenceParser.parseData(parseParagraph((String)text));
    }
}
