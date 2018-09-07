package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {

        StringBuilder sbuf = new StringBuilder(s.trim());
        Map<Integer, String> patterns = convertRomanToDecimal();
        int sum = 0;
        for (Map.Entry<Integer, String> pair : patterns.entrySet()) {
            int pos = sbuf.indexOf(pair.getValue());
            if (pos >= 0) {
                sum += pair.getKey();
                sbuf.delete(pos, pos + pair.getValue().length());
            }
        }

        return sum;
    }


    private static Map<Integer, String> convertRomanToDecimal() {

        Map<Integer, String> romanToDecimal = new LinkedHashMap<>();

        romanToDecimal.put(3000, "MMM");
        romanToDecimal.put(2000, "MM");
        romanToDecimal.put(900, "CM");
        romanToDecimal.put(1000, "M");
        romanToDecimal.put(800, "DCCC");
        romanToDecimal.put(700, "DCC");
        romanToDecimal.put(600, "DC");
        romanToDecimal.put(400, "CD");
        romanToDecimal.put(500, "D");
        romanToDecimal.put(300, "CCC");
        romanToDecimal.put(200, "CC");
        romanToDecimal.put(90, "XC");
        romanToDecimal.put(100, "C");
        romanToDecimal.put(80, "LXXX");
        romanToDecimal.put(70, "LXX");
        romanToDecimal.put(60, "LX");
        romanToDecimal.put(40, "XL");
        romanToDecimal.put(50, "L");
        romanToDecimal.put(30, "XXX");
        romanToDecimal.put(20, "XX");
        romanToDecimal.put(9, "IX");
        romanToDecimal.put(10, "X");
        romanToDecimal.put(8, "VIII");
        romanToDecimal.put(7, "VII");
        romanToDecimal.put(6, "VI");
        romanToDecimal.put(4, "IV");
        romanToDecimal.put(5, "V");
        romanToDecimal.put(3, "III");
        romanToDecimal.put(2, "II");
        romanToDecimal.put(1, "I");

        return romanToDecimal;
    }
}
