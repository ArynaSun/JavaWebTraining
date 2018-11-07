package entity;

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
}
