package com.javarush.test.level14.lesson08.home09;

/**
 * Created by iliashebanov on 22.08.16.
 */
public class Hrivna extends Money {
    private double amount;

    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
