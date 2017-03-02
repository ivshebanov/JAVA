package com.javarush.test.level14.lesson08.home09;

/**
 * Created by iliashebanov on 22.08.16.
 */
public class USD extends Money {
    private double amount;

    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
