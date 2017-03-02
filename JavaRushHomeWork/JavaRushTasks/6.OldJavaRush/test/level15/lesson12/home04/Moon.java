package com.javarush.test.level15.lesson12.home04;

/**
 * Created by iliashebanov on 15.09.16.
 */
public class Moon implements Planet {
    private static Moon mo;
    private Moon(){}
    public static Moon getInstance(){
        if (mo == null) mo = new Moon();
        return mo;
    }
}
