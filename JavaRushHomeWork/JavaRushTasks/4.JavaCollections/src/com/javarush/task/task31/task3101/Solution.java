package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> fileList = new ArrayList<File>();

    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        try {
            if (!resultFileAbsolutePath.exists()) resultFileAbsolutePath.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(allFilesContent, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        checkDirectory(path, allFilesContent);
        //        fileList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        fileList.sort(Comparator.comparing(File::getName));

        try {
            writFile(fileList, writer);
            assert writer != null;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writFile(List<File> list, BufferedWriter writer) throws IOException {
        for (File f : list) {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            while (reader.ready()) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            reader.close();
        }
    }

    private static void checkDirectory(File f, File allFilesContent) {
        try {
            Files.walkFileTree(f.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50 && !file.toFile().getAbsoluteFile().equals(allFilesContent.getAbsoluteFile()))
                        FileUtils.deleteFile(file.toFile());
                    else if (!file.toFile().getAbsoluteFile().equals(allFilesContent.getAbsoluteFile())) {
                        fileList.add(file.toFile());
                    }
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
