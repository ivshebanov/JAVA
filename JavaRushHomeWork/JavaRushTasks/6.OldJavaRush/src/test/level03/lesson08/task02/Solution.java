package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String ch1 = bufferedReader.readLine();
        String ch2 = bufferedReader.readLine();

        int CH1 = Integer.parseInt(ch1);
        int CH2 = Integer.parseInt(ch2);

        System.out.println(name + " получает " + CH1 + " через " + CH2 + " лет.");

    }
}