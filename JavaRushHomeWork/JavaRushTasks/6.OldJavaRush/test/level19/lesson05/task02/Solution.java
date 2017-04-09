package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String str = reader.readLine();
        //String str = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task02/file";
        BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int sum = 0;
        while (readFile.ready()){
            String itogStr = readFile.readLine();
            Pattern pattern = Pattern.compile("\\b[Ww]orld\\b[\\p{Punct}]? ?");
            Matcher matcher = pattern.matcher(itogStr);
            while (matcher.find()) {
                sum++;
            }
        }
        System.out.println(sum);
        readFile.close();
    }
}
