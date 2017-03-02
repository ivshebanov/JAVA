package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream1 = new FileOutputStream(new File(reader.readLine()));
        InputStream inputStream2 = new FileInputStream(reader.readLine());
        InputStream inputStream3 = new FileInputStream(reader.readLine());

        while (inputStream2.available() > 0){
            byte[] buffer = new byte[inputStream2.available()];
            int count = inputStream2.read(buffer);
            outputStream1.write(buffer, 0, count);
        }

        while (inputStream3.available() > 0){
            byte[] buffer = new byte[inputStream3.available()];
            int count = inputStream3.read(buffer);
            outputStream1.write(buffer, 0, count);
        }
        reader.close();
        inputStream2.close();
        inputStream3.close();
        outputStream1.close();
    }
}
