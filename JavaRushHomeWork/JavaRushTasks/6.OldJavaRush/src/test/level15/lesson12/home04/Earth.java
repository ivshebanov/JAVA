package com.javarush.test.level15.lesson12.home04;

/**
 * Created by iliashebanov on 15.09.16.
 */
public class Earth implements Planet {
    private static Earth sing;
    private Earth(){}
    public static Earth getInstance(){
        if (sing == null) sing = new Earth();
        return sing;
    }
}
