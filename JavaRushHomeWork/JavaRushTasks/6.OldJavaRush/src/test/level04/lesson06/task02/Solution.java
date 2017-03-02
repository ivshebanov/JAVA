package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String scum1 = reader.readLine();
        String scum2 = reader.readLine();
        String scum3 = reader.readLine();
        String scum4 = reader.readLine();

        int a = Integer.parseInt(scum1);
        int b = Integer.parseInt(scum2);
        int c = Integer.parseInt(scum3);
        int d = Integer.parseInt(scum4);

        if(a>b && a>c && a>d){
            System.out.println(a);
        }else{
            if(b>a && b>c && b>d){
                System.out.print(b);
            }else {
                if(c>a && c>b && c>d){
                    System.out.println(c);
                }else {
                    if (d>a && d>c && d>b){
                        System.out.println(d);
                    }
                }
            }
        }
    }
}
