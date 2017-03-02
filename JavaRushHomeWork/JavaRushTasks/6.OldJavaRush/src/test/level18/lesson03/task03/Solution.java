package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода

/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson03/task03/file
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
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
        int res = 0;

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry ne = iterator.next();
            if (res < (int)ne.getValue())
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
