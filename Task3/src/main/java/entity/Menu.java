package entity;

import java.util.List;

public class Menu {
    private List<Section> section;
    private String nameRestaurant;

    public Menu(){
    }

    public Menu(List<Section> section, String nameRestaurant) {
        this.section = section;
        this.nameRestaurant = nameRestaurant;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }
}
