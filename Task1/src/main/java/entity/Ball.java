package entity;

import java.io.Serializable;

public class Ball implements Serializable {

    private final int id;
    private double radius;
    private Point center;

    public Ball(int id) {
        this.id = id;
        center = new Point();
    }

    public Ball(int id, double radius, Point center) {
        this.id = id;
        this.radius = radius;
        this.center = center;

    }

    public int getId(){return id;}

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Ball object = (Ball) obj;

        if (object.radius != this.radius) {
            return false;
        }

        if (!object.center.equals(this.center)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int intRadius = (int) this.radius;
        int hashOfCenter = center.hashCode();

        return 17 * intRadius + 13 * hashOfCenter;
    }

    @Override
    public String toString() {
        return radius + " " + center.toString();
    }
}

