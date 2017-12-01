package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело обеих существующих функций min и исправить их возвращаемые значения.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        //напишите тут ваш код
        int j;
        int h = min(a, b);
        if(d < h) if(d < c) j = d; else j = c;
        else if(h < c) j = h;
        else j = c;
        return j;
    }

    public static int min(int a, int b)
    {
        //напишите тут ваш код
        int min;
        if(a < b) min = a;
        else min = b;
        return min;

    }

    public static void main(String[] args) throws Exception
    {
        System.out.println( min(-20, -10) );
        System.out.println( min(-20, -10, -30, -40) );
        System.out.println( min(-20, -10, -30, 40) );
    }
}