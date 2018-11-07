package entity;

import java.util.List;

public class ComplexDish {
    private String photo;
    private String nameDish;
    private List<ComplexDescription> complexDescription;
    private String portion;

    public ComplexDish(){}

    public ComplexDish(String photo, String nameDish, List<ComplexDescription> complexDescription, String portion) {
        this.photo = photo;
        this.nameDish = nameDish;
        this.complexDescription = complexDescription;
        this.portion = portion;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public List<ComplexDescription> getComplexDescription() {
        return complexDescription;
    }

    public void setComplexDescription(List<ComplexDescription> complexDescription) {
        this.complexDescription = complexDescription;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }
}
