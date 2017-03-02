package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        InputStream inputStream1 = new FileInputStream(file1);
        byte[] buff1 = new byte[inputStream1.available()];
        int count1 = inputStream1.read(buff1);
        InputStream inputStream2 = new FileInputStream(file2);
        byte[] buff2 = new byte[inputStream2.available()];
        int count2 = inputStream2.read(buff2);
        OutputStream outputStream = new FileOutputStream(file1);
        outputStream.write(buff2, 0, count2);
        outputStream.write(buff1, 0, count1);
        inputStream2.close();
        inputStream1.close();
        outputStream.close();
        reader.close();
    }
}
