package com.epam.jwt.task3.entity;

import java.util.List;

public class Menu {
    private List<Section> section;
    private String nameRestaurant;

    public Menu() {
    }

    public Menu(List<Section> section, String nameRestaurant) {
        this.section = section;
        this.nameRestaurant = nameRestaurant;
    }

    public List<Section> getSections() {
        return section;
    }

    public void setSections(List<Section> section) {
        this.section = section;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
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
        Menu menu = (Menu) obj;
        if (null == section) {
            return (section == menu.section);
        } else {
            if (!section.equals(menu.section)) {
                return false;
            }
        }
        if (null == nameRestaurant) {
            return (nameRestaurant == menu.nameRestaurant);
        } else {
            if ((!nameRestaurant.equals(menu.nameRestaurant))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (((null == section) ? 0 : section.hashCode() * 31) +
                ((nameRestaurant == null) ? 0 : nameRestaurant.hashCode() * 11));
    }

    @Override
    public String toString(){
        return getClass().getName() + "@" + "section: " + section + ", nameRestaurant: " + nameRestaurant;
    }
}
