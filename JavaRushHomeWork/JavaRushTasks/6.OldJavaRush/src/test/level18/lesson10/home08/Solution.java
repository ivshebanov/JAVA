package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String name = reader.readLine();
            if (name.equals("exit"))break;
            new ReadThread(name);
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body

        }
        // implement file reading here - реализуйте чтение из файла тут

    }
}
