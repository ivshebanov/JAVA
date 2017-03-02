package com.javarush.test.level09.lesson06.task01;

/* Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int a = 42 / 0;
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        try
        {
            method();
        }catch (ArithmeticException a){
            System.out.println("ArithmeticException");
        }
        //напишите тут ваш код

    }
    public static int method(){
        int a = 42/0;
        return a;
    }
}
