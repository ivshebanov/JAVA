package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    /*public static void main(String[] args){
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Date value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
    }*/

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("тл", new Date("JUNE 1 1980"));
        map.put("ук", new Date("JUNE 1 1980"));
        map.put("фы", new Date("JUNE 1 1980"));
        map.put("аа", new Date("JUNE 1 1980"));
        map.put("шл", new Date("JUNE 1 1980"));
        map.put("йц", new Date("JUNE 1 1980"));
        map.put("ма", new Date("JUNE 1 1980"));
        map.put("яч", new Date("JUNE 1 1980"));
        map.put("еп", new Date("JUNE 1 1980"));
        map.put("зл", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Date> pair = iterator.next();
            int value = pair.getValue().getMonth();
            //System.out.println(value);
            if (value > 4 && value < 8) iterator.remove();
        }
    }
}
