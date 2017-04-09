package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        clac(num1, num2, num3);
    }
    public static void clac(int a, int b, int c){
        int[] arr = {a, b, c};
        int d = 0;
        int f = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] < 0)
            {
                d++;
            } else
            {
                f++;
            }
        }
        System.out.println("количество отрицательных чисел: " + d);
        System.out.print("количество положительных чисел: " + f);
    }
}
