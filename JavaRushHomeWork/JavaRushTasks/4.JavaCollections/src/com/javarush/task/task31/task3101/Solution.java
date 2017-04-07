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
        resultFileAbsolutePath = allFilesContent;

        checkDirectory(path);
//        fileList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        fileList.sort(Comparator.comparing(File::getName));
        if (checkFi(fileList, resultFileAbsolutePath)) fileList.remove(resultFileAbsolutePath);
        writFile(resultFileAbsolutePath, fileList);
    }

    private static boolean checkFi(List<File> list, File result) {
        for (File s : list) {
            if (s.equals(result.getAbsoluteFile())) {
                return true;
            }
        }
        return false;
    }

    private static void writFile(File file, List<File> list) {
        for (File f : list) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))
            ) {
                while (reader.ready()) {
                    writer.write(reader.readLine());
                }
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkDirectory(File f) {
//        try {
//            Files.walkFileTree(f.toPath(), new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    if (file.toFile().length() > 50) FileUtils.deleteFile(file.toFile());
//                    else fileList.add(file.toFile());
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if(f.isDirectory()){
            for(File ff: f.listFiles()){
                checkDirectory(ff);
            }
        }
        else if(f.isFile()){
            if(f.length() > 50)
                FileUtils.deleteFile(f);
            else
                fileList.add(f);
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
