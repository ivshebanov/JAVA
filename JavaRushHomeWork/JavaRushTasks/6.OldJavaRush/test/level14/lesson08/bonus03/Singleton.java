package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by iliashebanov on 14.09.16.
 */
public class Singleton {
    private static final Singleton FIL = new Singleton();

    private Singleton(){};

    static Singleton getInstance(){
        return FIL;
    }
}
