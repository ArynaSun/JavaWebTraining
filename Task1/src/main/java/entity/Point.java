package entity;

import java.io.Serializable;

public class Point implements Serializable{

    private double x;
    private double y;
    private double z;

    public Point() {//нужен ли конструктор без параметров
    }

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public void setX(double x){
        this.x = x;
    }
    public  void setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Point object = (Point) obj;
        if(object.x != this.x){
            return false;
        }
        if(object.y != this.y){
            return false;
        }
        if(object.z != this.z){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        int intX = (int)this.x;
        int intY = (int)this.y;
        int intZ = (int)this.z;

        return 13*intX + 17*intY + 31*intZ;
    }
    @Override
    public String toString(){
        return "Point:" + x + " " + y + " " + z;
    }
}
