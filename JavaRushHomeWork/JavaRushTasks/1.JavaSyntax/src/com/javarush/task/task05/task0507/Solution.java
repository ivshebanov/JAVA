package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String str = reader.readLine();
        int sum = 0;
        int count = 0;
        while (!str.equals("-1")){
            count++;
            sum = sum + Integer.parseInt(str);
            str = reader.readLine();
        }
        System.out.println((double) sum/count);
    }
}

