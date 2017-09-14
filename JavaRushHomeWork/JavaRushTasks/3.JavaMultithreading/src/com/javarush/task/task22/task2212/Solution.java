package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    /**
     * Метод проверят номер телефона на валидность.
     *
     * @param telNumber входная строка с номером
     * @return {@code true} если номер телефона валидный, то возвращает true, иначе false
     */
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() == 0){
            return false;
        }
        Boolean test = false;
        String firstNum = telNumber.substring(0, 1);
        if (firstNum.equals("+") && lengthNumber(telNumber) == 12) {
            test = telNumber.matches("^(\\+\\d+\\(?\\d{3}\\)?)\\d+(-\\d+){0,2}$");
        }

        if (firstNum.equals("(") || firstNum.matches("[-+]?\\d+")) {
            if (lengthNumber(telNumber) == 10) {
                test = telNumber.matches("^(\\d+\\(?\\d{3}\\)?)\\d+(-\\d+){0,2}$");
            }
        }
        return test;
    }

    /**
     * Метод вычисляет сколько цифр в строке.
     *
     * @param telNumber входная строка с номером
     * @return колличество цифр в строке
     */
    private static int lengthNumber(String telNumber) {
        String pattern = "\\d";
        StringBuilder res = new StringBuilder();
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(telNumber);
        while (matcher.find()) {
            res.append(telNumber.substring(matcher.start(), matcher.end()));
        }
        return res.length();
    }

    /**
     * Вход в программу, тестовые номера.
     */
    public static void main(String[] args) {
        System.out.println("+380501234567 - true - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - true - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - true - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - true - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - false - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - false - "
                + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - false - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - false - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false - " + checkTelNumber("(0)501234567"));
    }
}
