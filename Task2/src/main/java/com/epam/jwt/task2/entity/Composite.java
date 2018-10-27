package com.epam.jwt.task2.entity;

public interface Composite extends PartOfText {

     void add (PartOfText partOfText);

     void remove(PartOfText partOfText);
}
