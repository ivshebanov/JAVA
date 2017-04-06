package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
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


        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\" + "allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        checkDirectory(path);
        collsort(fileList);
        writFile(allFilesContent, fileList);
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
            return o1.getName().compareTo(o2.getName());
        });
    }

    private static void checkDirectory(File file) {
        try {
            Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50) FileUtils.deleteFile(file.toFile());
                    else fileList.add(file.toFile());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
