package com.epam.jwt.task2.parser;

import com.epam.jwt.task2.entity.Lexeme;
import com.epam.jwt.task2.entity.Paragraph;
import com.epam.jwt.task2.entity.Sentence;
import com.epam.jwt.task2.entity.Text;

import java.util.ArrayList;
import java.util.List;

class TextParser implements StringParser {

    public Text parseText(List<List<List<String>>> lexemeFromText) {
        List<Paragraph> paragraphsFromText = new ArrayList<>();
        for (int i = 0; i < lexemeFromText.size(); i++) {
            List<Sentence> sentencesFromParagraph = new ArrayList<>();
            for (int j = 0; j < lexemeFromText.get(i).size(); j++) {
                List<Lexeme> lexemesFromSentence = new ArrayList<>();
                for (int k = 0; k < lexemeFromText.get(i).get(j).size(); k++) {
                    Lexeme lexeme = new Lexeme(lexemeFromText.get(i).get(j).get(k));
                    lexemesFromSentence.add(lexeme);
                }
                Sentence sentence = new Sentence(lexemesFromSentence);
                sentencesFromParagraph.add(sentence);
            }
            Paragraph paragraph = new Paragraph(sentencesFromParagraph);
            paragraphsFromText.add(paragraph);
        }
        Text text = new Text(paragraphsFromText);
        return text;
    }

    @Override
    public Text parseData(Object text) {
        return parseText((List<List<List<String>>>) text);
    }
}
