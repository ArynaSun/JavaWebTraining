package com.epam.jwt.task3.entity;

import java.util.List;

public class Section {

    private List<Dish> dishes;
    private List<ComplexDish> complexDish;
    private String name;

    public Section() {
    }


    public Section(List<Dish> dish, List<ComplexDish> complexDish, String name) {
        this.dishes = dish;
        this.complexDish = complexDish;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<ComplexDish> getComplexDish() {
        return complexDish;
    }

    public void setComplexDish(List<ComplexDish> complexDish) {
        this.complexDish = complexDish;
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

        Section section = (Section) obj;
        if (null == dishes) {
            return (dishes == section.dishes);
        } else {
            if (!dishes.equals(section.dishes)) {
                return false;
            }
        }

        if (null == complexDish) {
            return (complexDish == section.complexDish);
        } else {
            if (!complexDish.equals(section.complexDish)) {
                return false;
            }
        }

        if (null == name) {
            return (name == section.name);
        } else {
            if (!name.equals(section.name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (((null == dishes) ? 0 : dishes.hashCode() * 11) +
                ((null == complexDish) ? 0 : complexDish.hashCode() * 31) + ((null == name) ? 0 : name.hashCode() * 13));
    }

    @Override
    public String toString(){
        return getClass().getName() + "@" + "dishes: " + dishes + ", complexDish: " + ", name: " + name;
    }
}
