package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {

        if (args.length < 2) return;
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] readText = new byte[text.length()];
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            raf.seek(number);
            raf.read(readText, 0, readText.length);
            String readTextT = new String(readText, "UTF-8");
            if (readTextT.equals(text)) {
                raf.seek(raf.length());
                raf.write("true".getBytes());
            } else {
                raf.seek(raf.length());
                raf.write("false".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
