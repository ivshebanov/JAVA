package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map;

    static {
        map = new LinkedHashMap<>();
    }

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toLowerCase();
        CurrencyManipulator cm = map.get(currencyCode);
        if (cm == null) {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
            return map.get(currencyCode);
        }
        return cm;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
