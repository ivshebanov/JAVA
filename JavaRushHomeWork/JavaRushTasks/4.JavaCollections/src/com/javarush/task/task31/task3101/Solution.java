package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> fileList = new ArrayList<File>();

    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        checkDirectory(path);
        collsort(fileList);
        FileUtils.renameFile(resultFileAbsolutePath, resultFileAbsolutePath = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt"));
        writFile(resultFileAbsolutePath, fileList);
    }

    private static void writFile(File file, List<File> list) {
        for (File f : list) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))
            ) {
                while (reader.ready()) {
                    writer.write(reader.readLine() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void collsort(List<File> list) {
        list.sort((o1, o2) -> {
            String s1 = o1.getName();
            String s2 = o2.getName();
            return s1.compareTo(s2);
        });
    }

    private static void checkDirectory(File file) {
        for (File fileW : file.listFiles()) {
            if (fileW.isDirectory()) {
                if (fileW.listFiles().length != 0) {
                    checkDirectory(fileW);
                } else {
                    FileUtils.deleteFile(fileW);
                }
            } else {
                if (fileW.length() > 50) {
                    FileUtils.deleteFile(fileW);
                } else {
                    fileList.add(fileW);
                }
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
