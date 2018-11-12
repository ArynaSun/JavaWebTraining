package com.epam.jwt.task3.entity;

import java.util.List;

public class ComplexDish {
    private String photo;
    private String nameDish;
    private List<ComplexDescription> complexDescriptions;
    private String portion;

    public ComplexDish() {
    }

    public ComplexDish(String photo, String nameDish, List<ComplexDescription> complexDescriptions, String portion) {
        this.photo = photo;
        this.nameDish = nameDish;
        this.complexDescriptions = complexDescriptions;
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

    public List<ComplexDescription> getComplexDescriptions() {
        return complexDescriptions;
    }

    public void setComplexDescriptions(List<ComplexDescription> complexDescriptions) {
        this.complexDescriptions = complexDescriptions;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
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

        ComplexDish complexDish = (ComplexDish) obj;
        if (null == photo) {
            return (photo == complexDish.photo);
        } else {
            if (!photo.equals(complexDish.photo)) {
                return false;
            }
        }
        if (null == nameDish) {
            return (nameDish == complexDish.nameDish);
        } else {
            if (!nameDish.equals(complexDish.nameDish)) {
                return false;
            }
        }
        if (null == complexDescriptions) {
            return (complexDescriptions == complexDish.complexDescriptions);
        } else {
            if (!complexDescriptions.equals(complexDish.complexDescriptions)) {
                return false;
            }
        }
        if (null == portion) {
            return (portion == complexDish.portion);
        } else {
            if (!portion.equals(complexDish.portion)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (((null == photo) ? 0 : photo.hashCode() * 31) + ((null == nameDish) ? 0 : nameDish.hashCode() * 13) +
                ((null == complexDescriptions) ? 0 : complexDescriptions.hashCode() * 31) +
                ((null == portion) ? 0 : portion.hashCode() * 13));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "photo: " + photo + ", nameDish: " + nameDish +
                ", complexDescriptions: " + complexDescriptions + ", portion: " + portion;
    }
}
