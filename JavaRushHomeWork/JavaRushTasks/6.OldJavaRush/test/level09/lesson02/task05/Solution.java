package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем
(количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    /*public static void main(String[] args)
    {
        method1();
    }

    public static void method1()
    {
        method2();
    }

    public static void method2()
    {
        method3();
    }

    public static void method3()
    {
        getStackTraceDeep();
    }*/

    public static int getStackTraceDeep()
    {
        //напишите тут ваш код
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        int count = element.length;
        System.out.println(count);
        return count;
    }
}
