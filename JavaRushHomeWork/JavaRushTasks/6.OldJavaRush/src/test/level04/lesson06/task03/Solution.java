package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int a = Integer.parseInt(sNum1);
        int b = Integer.parseInt(sNum2);
        int c = Integer.parseInt(sNum3);

        if(a>b && a>c){
            System.out.println(a);
            if(b>c){
                System.out.println(b);
                System.out.println(c);
            }else {
                System.out.println(c);
                System.out.println(b);
            }
        }else {
            if(b>c && b>a){
                System.out.println(b);
                if(c>a){
                    System.out.println(c);
                    System.out.println(a);
                }else {
                    System.out.println(a);
                    System.out.println(c);
                }
            }else {
                if(c>a && c>b){
                    System.out.println(c);
                    if(a>b){
                        System.out.println(a);
                        System.out.println(b);
                    }else {
                        System.out.println(b);
                        System.out.println(a);
                    }
                }
            }
        }
    }
}
