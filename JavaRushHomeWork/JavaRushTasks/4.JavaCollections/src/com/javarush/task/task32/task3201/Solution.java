package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if (args.length < 3) {
            return;
        }
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        ) {
            if (number < 0) throw new IOException();
            if (number > randomAccessFile.length()) {
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(number);
            }
            randomAccessFile.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
