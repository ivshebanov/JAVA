package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args){
     /*   HashMap<String, String> map = createMap();
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
        System.out.println();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }*/
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("q", "a");
        map.put("w", "s");
        map.put("e", "d");
        map.put("r", "f");
        map.put("t", "g");
        map.put("y", "h");
        map.put("u", "h");
        map.put("i", "h");
        map.put("o", "h");
        map.put("p", "z");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashSet<String> map2 = new HashSet<String>();
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        //for (Map.Entry<String, String> pair: map.entrySet()) {
        while (iterator1.hasNext()){
            int count = 0;
            String name = iterator1.next().getValue();
            for (Map.Entry<String, String> pair1: map.entrySet()) {
                if (name.equals(pair1.getValue())) count++;
            }
            if (count > 1) map2.add(name);
        }
        for (String s: map2){
            removeItemFromMapByValue(map, s);
        }
        /*while(iterator1.hasNext()) {
            Map.Entry<String, String> pair1 = iterator1.next();
            String go = pair1.getValue();
            Iterator<Map.Entry<String, String>> iterator2 = map3.entrySet().iterator();
            while(iterator2.hasNext()) {
                Map.Entry<String, String> pair2 = iterator2.next();
                String go2 = pair2.getValue();
                if (go.equals(go2)) removeItemFromMapByValue(map, go);
            }
        }*/
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value){
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
