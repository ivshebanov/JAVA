package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new LinkedList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isRegularFile()) {
                    fileList.add(rootPath.relativize(file));
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
