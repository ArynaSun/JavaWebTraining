package com.epam.jwt.task2.parser;

import com.epam.jwt.task2.entity.Text;

import java.util.List;

public class ChainOfParser implements StringParser {

    private static ChainOfParser chainOfParser = new ChainOfParser();

    public static ChainOfParser getChainOfParser(){
        return chainOfParser;
    }

    private StringParser firstParserInChain;

    private ChainOfParser() {
        initChain();
    }

    private void initChain(){
        TextParser textParser = new TextParser();
        LexemeParser lexemeParser = new LexemeParser(textParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        firstParserInChain = paragraphParser;
    }

    @Override
    public Text parseData(Object text) {
        return firstParserInChain.parseData(text);
    }
}
