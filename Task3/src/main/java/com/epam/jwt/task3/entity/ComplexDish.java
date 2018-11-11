package com.epam.jwt.task3.entity;

import java.util.List;

public class ComplexDish {
    private String photo;
    private String nameDish;
    private List<ComplexDescription> complexDescription;
    private String portion;

    public ComplexDish() {
    }

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
        if (null == complexDescription) {
            return (complexDescription == complexDish.complexDescription);
        } else {
            if (!complexDescription.equals(complexDish.complexDescription)) {
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
                ((null == complexDescription) ? 0 : complexDescription.hashCode() * 31) +
                ((null == portion) ? 0 : portion.hashCode() * 13));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "photo: " + photo + ", nameDish: " + nameDish +
                ", complexDescription: " + complexDescription + ", portion: " + portion;
    }
}
