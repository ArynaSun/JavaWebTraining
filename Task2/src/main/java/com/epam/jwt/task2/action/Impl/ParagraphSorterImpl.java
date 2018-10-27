package com.epam.jwt.task2.action.Impl;

import com.epam.jwt.task2.action.ParagraphSorter;
import com.epam.jwt.task2.comparator.ParagraphComparator;
import com.epam.jwt.task2.entity.Paragraph;
import com.epam.jwt.task2.entity.Text;

import java.util.Comparator;
import java.util.List;

public class ParagraphSorterImpl implements ParagraphSorter {

    private static final ParagraphComparator PARAGRAPH_COMPARATOR = new ParagraphComparator();

    @Override
    public void sort(Text text) {
        text.getParagraphList().sort(PARAGRAPH_COMPARATOR);
    }
}
