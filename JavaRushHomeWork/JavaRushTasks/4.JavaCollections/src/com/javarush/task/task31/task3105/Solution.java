package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
D:\Hotj\JAVA\JavaRushHomeWork\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task31\task3105
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        ArrayList<ZipEntry> arrayList = new ArrayList<ZipEntry>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
             ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));){
            while (zipInputStream.available() != 0){
                arrayList.add(zipInputStream.getNextEntry());
        }
            String el0 = args[0];
            String s = "new\\" + el0.substring(el0.lastIndexOf("\\")+1);
            Path dir = Files.createDirectories(Paths.get(s));
            arrayList.add(new ZipEntry(dir.toString()));
            for (ZipEntry zi: arrayList){
                zipOutputStream.putNextEntry(zi);
            }
        }
    }
}
