package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    /*public static void main(String[] args){
        System.out.println(getCountTheSameFirstName(createMap(), "Илья"));
        System.out.println(getCountTheSameLastName(createMap(), "Шебанов"));

    }*/
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Шебанов", "Илья");
        map.put("Мартынова", "Настя");
        map.put("Волков", "Вадим");
        map.put("Фомичев", "Костя");
        map.put("Пономаренко", "Дарья");
        map.put("Лосева", "Лена");
        map.put("Петухов", "Вадим");
        map.put("Добромыслов", "Илья");
        map.put("Кучинский", "Илья");
        map.put("Малахов", "Олег");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int i = 0;
        for (String m: map.values()){
            if (m.equals(name))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int i = 0;
           for (String j: map.keySet()){
               if (j.equals(lastName))
                   i++;
           }
        return i;
    }
}
