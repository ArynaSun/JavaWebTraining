package com.epam.jwt.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements Composite {

    private List<Paragraph> paragraphList;

    public Text() {
        paragraphList = new ArrayList<>();
    }

    public Text(List<Paragraph> paragraphList) {
        setParagraphList(paragraphList);
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<Paragraph> paragraphList) {
        this.paragraphList = paragraphList;
    }

    @Override
    public void add(PartOfText partOfText) {
        paragraphList.add((Paragraph) partOfText);
    }

    @Override
    public void remove(PartOfText partOfText) {
        remove((Paragraph) partOfText);
    }

    @Override
    public String convertPartOfTextToString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < paragraphList.size(); i++) {
            stringBuffer.append(paragraphList.get(i).convertPartOfTextToString());
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
        Text text = (Text) obj;

        if (paragraphList == null) {
            return paragraphList == text.paragraphList;
        } else {
            if (!paragraphList.equals(text.paragraphList)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (paragraphList == null) ? 0 : paragraphList.hashCode() * 31;
    }

    @Override
    public String toString(){
        return getClass().getName() + "paragraphList: " + paragraphList;
    }
}
