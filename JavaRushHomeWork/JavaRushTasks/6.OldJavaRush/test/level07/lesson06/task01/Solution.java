package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> ilya = new ArrayList<String>();
        ilya.add(0, "a");
        ilya.add(1, "b");
        ilya.add(2, "c");
        ilya.add(3, "d");
        ilya.add(4, "e");

        System.out.println(ilya.size());

        for (int i = 0; i < ilya.size(); i++){
            System.out.println(ilya.get(i));
        }
    }
}
