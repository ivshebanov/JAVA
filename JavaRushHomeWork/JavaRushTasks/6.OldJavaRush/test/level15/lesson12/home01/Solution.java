package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Object s = null;
        while (true) {
            s = reader.readLine();
            try {
                if (s.toString().equals("exit")) break;
                else if (s.toString().contains(".")) print(Double.parseDouble(s.toString()));
                else if (Integer.parseInt(s.toString()) >= 128) print(Integer.parseInt(s.toString()));
                else if (Short.parseShort(s.toString()) > 0 && Short.parseShort(s.toString()) < 128) print(Short.parseShort(s.toString()));
            }
            catch (NumberFormatException e) {
                print(s.toString());
            }
        }

//        ArrayList<String> list = new ArrayList<String>();
//        while (true){
//            String s = reader.readLine();
//            if (s.equals("exit")) break;
//            list.add(s);
//        }
//        for (String s: list){
//            Double doe = tryParseDouble(s);
//            Short sh = tryParseShort(s);
//            Integer in = tryParseInt(s);
//
//            if (doe != null) {
//                print(doe);
//            } else if (sh != null && sh > 0 && sh < 128){
//                print(sh);
//            } else if (in != null && in >= 128){
//                print(in);
//            } else  print(s); //вывод для String
//        }
    }

//    private static Integer tryParseInt(String s) {
//        try {
//            return new Integer(s);
//        }catch (NumberFormatException e){
//            return null;
//        }
//    }
//    private static Double tryParseDouble(String s) {
//        if (s.matches("\\d+\\.\\d+")) return new Double(s);
//        else return null;
//    }
//    private static Short tryParseShort(String s) {
//        try {
//            return new Short(s);
//        }catch (NumberFormatException e){
//            return null;
//        }
//    }
    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
