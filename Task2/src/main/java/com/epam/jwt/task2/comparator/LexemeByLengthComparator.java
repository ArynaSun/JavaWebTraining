package com.epam.jwt.task2.comparator;

import com.epam.jwt.task2.entity.Lexeme;

import java.util.Comparator;

public class LexemeByLengthComparator implements Comparator<Lexeme> {
    @Override
    public int compare(Lexeme o1, Lexeme o2) {
        int size1 = o1.getLexeme().length();
        int size2 = o2.getLexeme().length();
        if (size1 == size2) {
            return 0;
        }
        return size1 > size2 ? 1 : -1;
    }
}
