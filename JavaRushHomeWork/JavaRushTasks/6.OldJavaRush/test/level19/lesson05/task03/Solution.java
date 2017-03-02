package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        //String name1 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task03/file1";
        //String name2 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task03/file2";
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        FileWriter fileWriter = new FileWriter(name2);
        reader.close();
        while (fileReader.ready()){
            String str = fileReader.readLine();
            Pattern pattern = Pattern.compile("\\b\\d*\\b");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                String i = str.substring(matcher.start(), matcher.end())+" ";
                if (!i.equals(" ")){
                    fileWriter.write(i);
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
