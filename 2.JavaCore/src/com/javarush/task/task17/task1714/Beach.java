package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public  Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized String toString() {
        return "Beach{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", quality=" + quality +
                '}';
    }

    public synchronized  String getName() {
        return name;
    }

    public  synchronized void setName(String name) {
        this.name = name;
    }

    public  synchronized float getDistance() {
        return distance;
    }

    public  synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public  synchronized int getQuality() {
        return quality;
    }

    public  synchronized  void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("Сочи", 2.2f, 5);
        Beach beach2 = new Beach("Крым", 1.2f, 2);
        Beach beach3 = new Beach("Крым", 1.2f, 2);
        System.out.println(beach1.compareTo(beach2)); //1
        System.out.println(beach2.compareTo(beach1)); //0


    }

    @Override
    public  synchronized int compareTo(Beach o) {
        int rating = 0;
        if(this.getDistance()>o.getDistance()){
                rating-=2;
        }
        else
        {
                if(this.getDistance()<o.getDistance()) {
                    rating += 2;
                }
        }
       // System.out.println(rating);
        if(this.getQuality()>o.getQuality()){
            rating+=3;
        }

        else {
                if(this.getQuality()<o.getQuality()){
                rating-=3;
                }
        }
       // System.out.println(rating);
        return rating;
    }
}
