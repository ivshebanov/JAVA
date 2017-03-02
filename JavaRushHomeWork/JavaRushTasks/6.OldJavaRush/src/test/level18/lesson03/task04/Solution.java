package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.Map.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        int count = 0;
        for (Integer i : list)
        {
            for (Integer j : list)
            {
                if (i == j) count++;
            }
            map.put(i, count);
            count = 0;
        }
        int znach = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int res = iterator.next().getValue();
        while (iterator.hasNext())
        {
            Entry ne = iterator.next();
            if (res > (int)ne.getValue())
            {
                res = (int)ne.getValue();
                znach = (int)ne.getKey();
                iterator.remove();
            }

        }
        result.add(znach);

        for (Map.Entry<Integer, Integer> m : map.entrySet())
        {
            if (res == m.getValue())
            {
                result.add(m.getKey());
            }
        }
        for (Integer ok : result)
        {
            System.out.print(ok + " ");
        }

        reader.close();
        inputStream.close();
    }
}
