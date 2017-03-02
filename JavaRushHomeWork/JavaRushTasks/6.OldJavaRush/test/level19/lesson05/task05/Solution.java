package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
//        String name1 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task05/file1";
//        String name2 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task05/file2";
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        FileWriter fileWriter = new FileWriter(name2);
        while (fileReader.ready()){
            String str = fileReader.readLine();
            Pattern pattern = Pattern.compile("\\p{Punct}");
            Matcher matcher = pattern.matcher(str);
            String itog = str;
            while (matcher.find()){
                String sim = str.substring(matcher.start(), matcher.end());
                itog = itog.replace(sim, "");
            }
            fileWriter.write(itog);
        }
        fileReader.close();
        fileWriter.close();
    }
}
