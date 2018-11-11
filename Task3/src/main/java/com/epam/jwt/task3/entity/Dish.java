package com.epam.jwt.task3.entity;

public class Dish {
    private String photo;
    private String nameDish;
    private String description;
    private String portion;
    private int price;

    public Dish() {
    }

    public Dish(String photo, String nameDish, String description, String portion, int price) {
        this.photo = photo;
        this.nameDish = nameDish;
        this.description = description;
        this.portion = portion;
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNameDish() {
        return nameDish;
    }

    public String getDescription() {
        return description;
    }

    public String getPortion() {
        return portion;
    }

    public int getPrice() {
        return price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPortion(String portion) {
        this.portion = portion;
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

        Dish dish = (Dish) obj;
        if (null == photo) {
            return (photo == dish.photo);
        } else {
            if (!photo.equals(dish.photo)) {
                return false;
            }
        }
        if (null == nameDish) {
            return (nameDish == dish.nameDish);
        } else {
            if (!nameDish.equals(dish.nameDish)) {
                return false;
            }
        }
        if (null == description) {
            return (description == dish.description);
        } else {
            if (!description.equals(dish.description)) {
                return false;
            }
        }
        if (null == portion) {
            return (portion == dish.portion);
        } else {
            if (!portion.equals(dish.portion)) {
                return false;
            }
        }
        if (price != dish.price) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (((null == photo) ? 0 : photo.hashCode() * 31) + ((null == nameDish) ? 0 : nameDish.hashCode() * 11) +
                ((null == description) ? 0 : description.hashCode() * 31) +
                ((null == portion) ? 0 : portion.hashCode() * 31) + price * 31);
    }

    @Override
    public String toString(){
        return getClass().getName() + "@" + "photo: " + photo + ", nameDish: " + nameDish + ", description: " +
                description + ", portion: " + portion + ", price: " + price;
    }
}
