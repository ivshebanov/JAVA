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
    public static void main(String[] args) throws IOException {
//        File path = new File(args[0]);
//        File resultFileAbsolutePath = new File(args[1]);
//        if (!resultFileAbsolutePath.exists()) try {
//            resultFileAbsolutePath.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
//        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
//
//        List<File> fileList = checkDirectory(path);
//
//        if (fileList.contains(allFilesContent)) {
//            fileList.remove(allFilesContent);
//        }
//
//        fileList.sort(Comparator.comparing(File::getName));
//
//
//        try (FileOutputStream writer = new FileOutputStream(allFilesContent)) {
//            for (File f : fileList) {
//                try (BufferedReader reader = new BufferedReader(new FileReader(f));){
//                    while (reader.ready()) {
//                        writer.write(reader.read());
//                    }
//                    writer.write("\n".getBytes());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File dest = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, dest);
        ArrayList<File> list = new ArrayList<>();
        try (FileOutputStream writer = new FileOutputStream(dest)) {
            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50) {
                        FileUtils.deleteFile(file.toFile());
                    } else {
                        list.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            list.sort(Comparator.comparing(File::getName));

            for (File file : list) {
                if (!file.equals(dest)) {
                    FileReader reader = new FileReader(file);
                    while (reader.ready()) writer.write(reader.read());
                    reader.close();
                    writer.write("\n".getBytes());
                }
            }
            writer.close();
        }
    }

//    private static List<File> checkDirectory(File f) {
//        List<File> fileList = new ArrayList<File>();
//        try {
//            Files.walkFileTree(f.toPath(), new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    if (file.toFile().length() > 50) {
//                        FileUtils.deleteFile(file.toFile());
//                    } else {
//                        fileList.add(file.toFile());
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return fileList;
//    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
