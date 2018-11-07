package entity;

public class ComplexDescription {

    private String ingredient;
    private int price;

    public ComplexDescription(){
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
}
