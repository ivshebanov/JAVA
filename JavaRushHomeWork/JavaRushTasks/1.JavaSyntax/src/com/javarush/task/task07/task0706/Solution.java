package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ho = new int[15];
        for (int i = 0; i < 15; i++){
            ho[i] = Integer.parseInt(reader.readLine());
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 15; i++){
            if (i == 0){
                count2 = count2 + ho[i];
            }
            if (i % 2 == 0){
                count2 = count2 + ho[i];
            }
            if (i % 2 == 1){
                count1 = count1 + ho[i];
            }
        }
        if (count1<count2){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
