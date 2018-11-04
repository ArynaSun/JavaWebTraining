package com.epam.jwt.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Composite {

    private List<Lexeme> lexemeList;

    public Sentence() {
        lexemeList = new ArrayList<>();
    }

    public Sentence(List<Lexeme> lexemeList) {
        setLexemeList(lexemeList);
    }

    public List<Lexeme> getLexemeList() {
        return lexemeList;
    }

    public void setLexemeList(List<Lexeme> lexemeList) {
        this.lexemeList = lexemeList;
    }

    @Override
    public void add(PartOfText partOfText) {
        lexemeList.add((Lexeme) partOfText);
    }

    @Override
    public void remove(PartOfText partOfText) {
        lexemeList.remove((Lexeme) partOfText);

    }

    @Override
    public String convertPartOfTextToString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lexemeList.size(); i++) {
            stringBuffer.append(lexemeList.get(i).convertPartOfTextToString());
            stringBuffer.append("\\s");
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Sentence sentence = (Sentence) obj;

        if (lexemeList == null) {
            return lexemeList == sentence.lexemeList;
        } else {
            if (!lexemeList.equals(sentence.lexemeList)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (lexemeList == null) ? 0 : lexemeList.hashCode() * 31;
    }

    @Override
    public String toString() {
        return getClass().getName() + "lexemeList: " + lexemeList;
    }
}
