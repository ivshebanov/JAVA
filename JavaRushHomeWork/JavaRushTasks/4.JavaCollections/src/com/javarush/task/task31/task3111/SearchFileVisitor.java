package com.javarush.task.task31.task3111;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isTrue = true;

        String name = file.getFileName().toString();
        if (partOfName != null && !(name.contains(partOfName))) {
            isTrue = false;
        }
        if (partOfContent != null) {
            String content = new String(Files.readAllBytes(file));
            if (!(content.contains(partOfContent))) {
                isTrue = false;
            }
        }
        if (!(maxSize == 0) && attrs.isRegularFile() && !(attrs.size() <= maxSize)) {
            isTrue = false;
        }
        if (!(minSize == 0) && attrs.isRegularFile() && !(attrs.size() >= minSize)) {
            isTrue = false;
        }
        if (isTrue) {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
