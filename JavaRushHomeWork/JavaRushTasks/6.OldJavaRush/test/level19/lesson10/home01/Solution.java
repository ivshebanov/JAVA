package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson10/home01/file
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new ConcurrentHashMap<String, Double>();
        while (fileRead.ready()){
            String str = fileRead.readLine();
            String[] name = str.split(" ");
            if (map.size() != 0){
                boolean chec = false;
                Iterator<Map.Entry<String, Double>> itr = map.entrySet().iterator();
                while (itr.hasNext()){
                    Map.Entry<String, Double> pair = itr.next();
                    if (name[0].equals(pair.getKey())){
                        map.put(name[0], pair.getValue()+Double.parseDouble(name[1]));
                        chec = true;
                    }
                }
                if (!chec){
                    map.put(name[0], Double.parseDouble(name[1]));
                }
            }else {
                map.put(name[0], Double.parseDouble(name[1]));
            }
        }
        Map<String, Double> sortedMap = new TreeMap<String, Double>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(map);
        for (Map.Entry<String, Double> f: sortedMap.entrySet()){
            System.out.println(f.getKey() + " " + f.getValue());
        }
        fileRead.close();
    }
}
