package com.epam.jwt.task2.action.Impl;

import com.epam.jwt.task2.action.LexemeSorter;
import com.epam.jwt.task2.comparator.LexemeByCharacterEntryComparator;
import com.epam.jwt.task2.comparator.LexemeByLengthComparator;
import com.epam.jwt.task2.entity.Text;

public class LexemeSorterImpl implements LexemeSorter {

    private static final LexemeByLengthComparator LEXEMA_COMPARATOR = new LexemeByLengthComparator();
    private static final LexemeByCharacterEntryComparator CHARACTER_ENTRY_COMPARATOR = new LexemeByCharacterEntryComparator();

    @Override
    public void sortByLength(Text text) {
        for (int i = 0; i < text.getParagraphList().size(); i++) {
            for (int j = 0; j < text.getParagraphList().get(i).getSentenceList().size(); j++) {
                text.getParagraphList().get(i).getSentenceList().get(j).getLexemeList().sort(LEXEMA_COMPARATOR);
            }
        }
    }

    @Override
    public void sortByCharacterEntry(char symbol, Text text) {
        CHARACTER_ENTRY_COMPARATOR.setSymbol(symbol);
        for (int i = 0; i < text.getParagraphList().size(); i++) {
            for (int j = 0; j < text.getParagraphList().get(i).getSentenceList().size(); j++) {
                text.getParagraphList().get(i).getSentenceList().get(j).getLexemeList().sort(CHARACTER_ENTRY_COMPARATOR);
            }
        }
    }
}
