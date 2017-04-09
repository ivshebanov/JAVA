package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Администратор on 16.01.2017.
 */

public class Horse extends Hippodrome{
    public String name;
    public double speed;
    public double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        this.distance += this.speed*Math.random();
    }

    public void print(){
        String dot = ".";
        for (int i = 0; i < this.distance; i++){
            System.out.print(dot);
        }
        System.out.println("|" + this.name);
    }

    public String getName() {
        return name;
    }
    public double getSpeed()
    {
        return speed;
    }
    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}
