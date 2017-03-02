package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        OutputStream outputStream = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buff = new byte[inputStream.available()];
        while (inputStream.available()>0){
            int count = inputStream.read(buff);
        }
        inputStream.close();
        for (int i = buff.length; i > 0; i--){
            outputStream.write(buff[i-1]);
        }
        outputStream.close();
    }
}
