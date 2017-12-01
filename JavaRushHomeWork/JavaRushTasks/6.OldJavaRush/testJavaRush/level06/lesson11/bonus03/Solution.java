package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] ilya = new int[5];

        for (int i = 0; i < ilya.length; i++){
            ilya[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 4; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (ilya[j] > ilya[j + 1]){
                    int f = ilya[j];
                    ilya[j] = ilya[j + 1];
                    ilya[j + 1] = f;
                }
            }
        }
        for (int i = 0; i < ilya.length; i++){
            System.out.println(ilya[i]);
        }
    }
}
