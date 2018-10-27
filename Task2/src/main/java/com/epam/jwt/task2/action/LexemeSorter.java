package com.epam.jwt.task2.action;

import com.epam.jwt.task2.entity.Text;

public interface LexemeSorter {
    void sortByLength(Text text);

    void sortByCharacterEntry(char symbol, Text text);
}
