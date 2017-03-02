package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
//        String name1 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task01/file1";
//        String name2 = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson05/task01/file2";
        reader.close();

        InputStream inputStream = new FileInputStream(name1);
        OutputStream outputStream = new FileOutputStream(name2);
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        for (int i = 0; i < buff.length ; i++){
            if (0!=i%2){
                outputStream.write(buff[i]);
            }
        }
        inputStream.close();
        outputStream.close();
    }
}
