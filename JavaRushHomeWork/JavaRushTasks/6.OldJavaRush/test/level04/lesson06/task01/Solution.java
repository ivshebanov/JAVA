package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        min(aa, bb);
    }
    public static void min(int a, int b){
        if(a<b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}