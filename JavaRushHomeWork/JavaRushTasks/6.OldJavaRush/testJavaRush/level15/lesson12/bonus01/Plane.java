package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by iliashebanov on 16.09.16.
 */
public class Plane implements Flyable {
    public int passengers;
    public Plane(int a){
        this.passengers = a;
    }
    @Override
    public void fly() {

    }
}
