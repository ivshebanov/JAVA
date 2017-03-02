package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        try {
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
            Double znach = 0.;
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if (znach < entry.getValue()){
                    znach = entry.getValue();
                }
            }
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if (znach.equals(entry.getValue())){
                    System.out.println(entry.getKey() + " ");
                }
            }
            fileRead.close();
        }catch (FileNotFoundException ex1){
        }catch (IOException ex1){
        }

    }
}
