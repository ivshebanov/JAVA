package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson03/task03/file
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        TreeSet<Integer> set = new TreeSet<Integer>();
        while (inputStream.available() > 0){
            set.add(inputStream.read());
        }
        for (Integer ug: set){
            System.out.println(ug);
        }
        reader.close();
        inputStream.close();
    }
}
