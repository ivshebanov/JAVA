package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum1 = reader.readLine();
        String sNum2 = reader.readLine();
        String sNum3 = reader.readLine();
        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);
        int num3 = Integer.parseInt(sNum3);
        chislo(num1, num2, num3);
    }
    public static void chislo(int a, int b, int c){
        if((a == b) && (a == c) && (c == b)){
            System.out.println(a +" "+ b +" "+ c);
        }else{
            if(a == b){
                System.out.println(a + " " + b);
            }else {
                if(a == c){
                    System.out.println(a + " " + c);
                }else {
                    if(b == c){
                        System.out.println(c + " " + b);
                    }
                }
            }
        }
    }
}