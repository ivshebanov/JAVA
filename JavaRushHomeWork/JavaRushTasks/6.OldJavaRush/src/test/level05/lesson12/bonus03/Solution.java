package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int f = 0;

        for (int y = 0; y < n; y++){
            int ch = Integer.parseInt(reader.readLine());
            arr[y] = ch;
        }

        for (int i = n-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[j + 1]) {
                    f = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = f;
                }
            }
        }

        System.out.println(arr[0]);
        //напишите тут ваш код



       // System.out.println(maximum);
    }
}
