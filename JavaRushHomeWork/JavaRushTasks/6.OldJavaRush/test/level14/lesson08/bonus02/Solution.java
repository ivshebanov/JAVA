package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int u = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int l;
        if (u < y) l = y;
        else l = u;
        for (int i = l; i > 1; i--){
            if (u % i == 0 && y % i == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
