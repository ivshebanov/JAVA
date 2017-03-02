package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] m1 = new int[5];
        m1[0] = 1;
        m1[1] = 1;
        m1[2] = 1;
        m1[3] = 1;
        m1[4] = 1;
        int[] m2 = new int[2];
        m2[0] = 1;
        m2[1] = 1;
        int[] m3 = new int[4];
        m3[0] = 1;
        m3[1] = 1;
        m3[2] = 1;
        m3[3] = 1;
        int[] m4 = new int[7];
        m4[0] = 1;
        m4[1] = 1;
        m4[2] = 1;
        m4[3] = 1;
        m4[4] = 1;
        m4[5] = 1;
        m4[6] = 1;
        int[] m5 = new int[0];

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
