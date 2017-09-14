package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона

1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        Boolean test = false;
        String firstNum = telNumber.substring(0, 1);
        if (firstNum.equals("+")){
            String pattern = "\\d";
            StringBuilder res = new StringBuilder();
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(telNumber);
            while(m.find()) {
                res.append(telNumber.substring(m.start(), m.end()));
            }
//            System.out.println(res.length());
            if (res.length()==12){
                test = telNumber.matches("^(\\+\\d+\\(?\\d{3}\\)?)\\d+(-\\d+){0,2}$");
            }
        }

        if (firstNum.equals("(") || firstNum.matches("[-+]?\\d+")){
            String pattern = "\\d";
            StringBuilder res = new StringBuilder();
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(telNumber);
            while(m.find()) {
                res.append(telNumber.substring(m.start(), m.end()));
            }
//            System.out.println(res.length());
            if (res.length()==12){

            }
        }
        return test;
    }

    //вынести в отдельный метод проверку длинны

    public static void main(String[] args) {
        System.out.println("+380501234567 - true - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - true - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - true - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - true - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - false - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - false - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - false - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - false - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false - " + checkTelNumber("(0)501234567"));
    }
}
