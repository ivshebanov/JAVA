package com.javarush.test.level09.lesson11.bonus02;

import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        zap();
    }
    private static void zap() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            String sourceFileName = reader.readLine();
            String destinationFileName = reader.readLine();
            fileInputStream = new FileInputStream(sourceFileName);
            fileOutputStream = new FileOutputStream(destinationFileName);
            while (fileInputStream.available() > 0)
            {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
            fileInputStream.close();
            fileOutputStream.close();
            reader.close();
        }catch (IOException e){
            System.out.println("Файл не существует.");
            String sourceFileName = reader.readLine();
            String destinationFileName = reader.readLine();
        }
    }
}