package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.SimpleDateFormat; // библиотека для системного времени

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        long curTime = System.currentTimeMillis();//Выводит машинное время
        //Date curDate = new Date(curTime); //выводит текущую дату
        String curStringDate = new SimpleDateFormat("dd MM yyyy").format(curTime);
        //выводит текущую дату в нужном формате
        System.out.println(curStringDate);
    }
}
