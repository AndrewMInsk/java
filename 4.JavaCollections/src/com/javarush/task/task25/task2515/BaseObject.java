package com.javarush.task.task25.task2515;

abstract public class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
////
    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }
    BaseObject (double x, double y, double radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.isAlive=true;
    }
    public void  draw(){}
    public void  move(){}
    public void  die(){
        this.isAlive=false;
    }
    public boolean isIntersect(BaseObject o){
        double xDif = o.getX()-this.getX();
        double yDif = o.getY()-this.getY();
        double distance = Math.sqrt(Math.pow(xDif,2)+Math.pow(yDif,2));

        if(distance<Math.max(o.getRadius(),this.getRadius())){
            return true;
        }
else

        return false;
    }
}
