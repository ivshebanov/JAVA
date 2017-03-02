package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        String s1 = "";
        int d1 = 256;
        int ind1 = 0;

        String s2 = "";
        int d2 = 0;
        int ind2 = 0;

        int count = 0;
        for (String e : list) {
            if (d1 > e.length()) {
                s1 = e;
                d1 = e.length();
                ind1 = count;
            }
            if (d2 < e.length()) {
                s2 = e;
                d2 = e.length();
                ind2 = count;
            }
            count++;
        }
        if (ind1 > ind2) {
            System.out.println(s2);
        } else {
            System.out.println(s1);
        }
    }
}
