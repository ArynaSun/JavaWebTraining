package com.epam.jwt.task3.entity;

import java.util.List;

public class Section {

    private List<Dish> dishes;
    private List<ComplexDish> complexDishes;
    private String name;

    public Section() {
    }


    public Section(List<Dish> dish, List<ComplexDish> complexDishes, String name) {
        this.dishes = dish;
        this.complexDishes = complexDishes;
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

    public List<ComplexDish> getComplexDishes() {
        return complexDishes;
    }

    public void setComplexDishes(List<ComplexDish> complexDishes) {
        this.complexDishes = complexDishes;
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

        if (null == complexDishes) {
            return (complexDishes == section.complexDishes);
        } else {
            if (!complexDishes.equals(section.complexDishes)) {
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
        return (((null == dishes) ? 0 : dishes.hashCode() * 11) +
                ((null == complexDishes) ? 0 : complexDishes.hashCode() * 31) + ((null == name) ? 0 : name.hashCode() * 13));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "dishes: " + dishes + ", complexDishes: " + ", name: " + name;
    }
}
