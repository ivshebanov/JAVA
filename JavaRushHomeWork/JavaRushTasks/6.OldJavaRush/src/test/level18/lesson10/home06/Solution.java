package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        InputStream inputStream = new FileInputStream(new File(args[0]));
        byte[] buff = new byte[inputStream.available()];
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        ArrayList<Character> list = new ArrayList<Character>();
        char[] mas = new char[0];
        while (inputStream.available()>0){
            inputStream.read(buff);
            mas = new String(buff).toCharArray();
        }
        inputStream.close();
        for (char r: mas){
            if (map.containsKey(r)) {
                int val = map.get(r)+1;
                map.put(r, val);
            }else {
                map.put(r, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}


/*    InputStream inputStream = new FileInputStream(new File(args[0]));
    byte[] buff = new byte[inputStream.available()];
    char[] mas = new char[0];
    TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        while (inputStream.available()>0){
                inputStream.read(buff);
                mas = new String(buff).toCharArray();
                }


                for (char r: mas){
                if (map.containsKey(r)) {
                int val = map.get(r)+1;
                map.put(r, val);
                }else {
                map.put(r, 1);
                }
                }
                for (Map.Entry<Character, Integer> entry: map.entrySet()){
        System.out.println(entry.getKey() + " " + entry.getValue());
        }
        inputStream.close();*/