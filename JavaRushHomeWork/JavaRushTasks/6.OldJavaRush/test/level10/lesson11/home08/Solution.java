package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] a = new ArrayList[5];

        ArrayList<String> awq = new ArrayList<String>();
        awq.add("asd");
        awq.add("asdwqe");
        ArrayList<String> awq1 = new ArrayList<String>();
        awq1.add("asd");
        ArrayList<String> awq2 = new ArrayList<String>();
        awq2.add("asd");
        ArrayList<String> awq3 = new ArrayList<String>();
        awq3.add("asd");
        ArrayList<String> awq4 = new ArrayList<String>();
        awq4.add("asd");
        a[0] = awq;
        a[1] = awq1;
        a[2] = awq2;
        a[3] = awq3;
        a[4] = awq4;
        return a;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}