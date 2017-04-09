package com.javarush.test.level15.lesson12.home04;

/**
 * Created by iliashebanov on 15.09.16.
 */
public class Sun implements Planet {
    private static Sun su;
    private Sun(){}
    public static Sun getInstance(){
        if (su == null) su = new Sun();
        return su;
    }
}
