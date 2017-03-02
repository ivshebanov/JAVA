package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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
        pri(num1, num2, num3);


    }
    public static void pri(int a, int b, int c){
        int[] arr = {a, b, c};
        int d = 0;
        for(int i = 0; i < 3; i++){
            if(arr[i] > 0){
                d++;
            }
        }
        System.out.println(d);
    }
}
