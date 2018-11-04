package com.epam.jwt.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Composite {

    private List<Sentence> sentenceList;

    public Paragraph() {
        sentenceList = new ArrayList<>();
    }

    public Paragraph(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    @Override
    public void add(PartOfText partOfText) {
        sentenceList.add((Sentence) partOfText);
    }

    @Override
    public void remove(PartOfText partOfText) {
        sentenceList.remove((Sentence) partOfText);
    }

    @Override
    public String convertPartOfTextToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t");
        for (int i = 0; i < sentenceList.size(); i++) {
            stringBuffer.append(sentenceList.get(i).convertPartOfTextToString());
        }
        stringBuffer.append("\n");

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

        Paragraph paragraph = (Paragraph) obj;

        if (sentenceList == null) {
            return sentenceList == paragraph.sentenceList;
        } else {
            if (!sentenceList.equals(paragraph.sentenceList)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (sentenceList == null) ? 0 : sentenceList.hashCode() * 31;
    }

    @Override
    public String toString() {
        return getClass().getName() + "sentenceList: " + sentenceList;
    }
}
