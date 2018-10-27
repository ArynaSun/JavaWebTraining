package com.epam.jwt.task2.comparator;

import com.epam.jwt.task2.entity.Paragraph;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Paragraph> {

    @Override
    public int compare(Paragraph o1, Paragraph o2) {
        int size1 = o1.getSentenceList().size();
        int size2 = o2.getSentenceList().size();
        if (size1 == size2) {
            return 0;
        }
        return size1 > size2 ? 1 : -1;
    }
}
