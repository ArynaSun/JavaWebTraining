package com.epam.jwt.task3.entity;

import java.util.List;

public class Section {

    private List<Dish> dish;
    private List<ComplexDish> complexDish;
    private String name;

    public Section(){}


    public Section(List<Dish> dish, List<ComplexDish> complexDish, String name) {
        this.dish = dish;
        this.complexDish = complexDish;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }

    public List<ComplexDish> getComplexDish() {
        return complexDish;
    }

    public void setComplexDish(List<ComplexDish> complexDish) {
        this.complexDish = complexDish;
    }
}
