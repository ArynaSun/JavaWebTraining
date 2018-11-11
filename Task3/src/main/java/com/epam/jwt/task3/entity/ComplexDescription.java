package com.epam.jwt.task3.entity;

public class ComplexDescription {

    private String ingredient;
    private int price;

    public ComplexDescription() {
    }

    public ComplexDescription(String ingredient, int price) {
        this.ingredient = ingredient;
        this.price = price;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getPrice() {
        return price;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setPrice(int price) {
        this.price = price;
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

        ComplexDescription complexDescription = (ComplexDescription) obj;

        if (price != complexDescription.price) {
            return false;
        }
        if (null == ingredient) {
            return (ingredient == complexDescription.ingredient);
        } else {
            if (!ingredient.equals(complexDescription.ingredient)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((price * 31) + ((null == ingredient) ? 0 : ingredient.hashCode() * 31));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "price: " + price + ", ingredient: " + ingredient;
    }
}
