package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
//        String name1 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task04/file1";
//        String name2 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task04/file2";
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        FileWriter fileWriter = new FileWriter(name2);
        while (fileReader.ready()){
            String str = fileReader.readLine();
            fileWriter.write(str.replace(".", "!"));
        }
        fileReader.close();
        fileWriter.close();
    }
}
