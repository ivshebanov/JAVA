package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> Ilya = new ArrayList<String>();
        Ilya.add("мама");
        Ilya.add("мыла");
        Ilya.add("раму");
        for (int i = 1; i < Ilya.size() + 1; i = i + 2){
            Ilya.add(i, "именно");
        }
        for (int i = 0; i < Ilya.size(); i++){
            System.out.println(Ilya.get(i));
        }

    }
}
