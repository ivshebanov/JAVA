package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
D:\Hotj\JAVA\JavaRushHomeWork\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task31\task3111
*/
public class Solution {
    private static int countDirectory = 0;
    private static int countFile = 0;
    private static long sizeFile = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            Path path = Paths.get(reader.readLine());
            if (!Files.isDirectory(path)) {
                System.out.println(path + " - " + "не папка");
            } else {
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        if (Files.isDirectory(dir)) {
                            countDirectory();
                        }
                        return super.preVisitDirectory(dir, attrs);
                    }
                });
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (Files.isRegularFile(file)) {
                            countFile();
                            sizeFile(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
            countDirectory = countDirectory - 1;
            System.out.println("Всего папок - " + countDirectory);
            System.out.println("Всего файлов - " + countFile);
            System.out.println("Общий размер - " + sizeFile);
        }
    }

    private static void countDirectory() {
        countDirectory++;
    }

    private static void countFile() {
        countFile++;
    }

    private static void sizeFile(Path file) {
        try {
            sizeFile = sizeFile + Files.size(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
