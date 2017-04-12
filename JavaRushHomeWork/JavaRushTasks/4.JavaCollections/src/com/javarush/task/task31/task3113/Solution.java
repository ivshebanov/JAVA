package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
D:\Hotj\JAVA\JavaRushHomeWork\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task31\task3111
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
            Path pach = Paths.get(reader.readLine());
            if (!Files.isDirectory(pach)){
                System.out.println(pach);
            }
        }
    }
}
