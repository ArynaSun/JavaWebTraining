package com.epam.jwt.task2.comparator;

import com.epam.jwt.task2.entity.Lexeme;

import java.util.Comparator;

public class LexemeByCharacterEntryComparator implements Comparator<Lexeme> {

    private char symbol;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(Lexeme o1, Lexeme o2) {
        int countSymbolsInLexeme1 = countSymbolsIn(o1.getLexeme().toCharArray());
        int countSymbolsInLexeme2 = countSymbolsIn(o2.getLexeme().toCharArray());
        if (countSymbolsInLexeme1 == countSymbolsInLexeme2) {
            return o1.getLexeme().compareTo(o2.getLexeme());
        }
        return countSymbolsInLexeme1 > countSymbolsInLexeme2 ? 1 : -1;
    }

    public int countSymbolsIn(char[] lexeme) {
        int count = 0;
        for (int i = 0; i < lexeme.length; i++) {
            if (lexeme[i] == symbol) {
                count++;
            }
        }
        return count;
    }
}
