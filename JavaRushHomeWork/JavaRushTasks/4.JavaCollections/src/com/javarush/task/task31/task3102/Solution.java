package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
//    public static List<String> getFileTree(String root) throws IOException {
//        List<String> list = new LinkedList<String>();
//
//        try {
//            Files.walkFileTree(/*new File(root).toPath()*/Paths.get(root), new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    list.add(file.toFile().getAbsolutePath());
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public static void main(String[] args) {

        //Path path = Paths.get("D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3102\\test.txt");
        String s = "Shebanov";
        if (!s.isEmpty()){
            System.out.println(s);
        }
    }
}
