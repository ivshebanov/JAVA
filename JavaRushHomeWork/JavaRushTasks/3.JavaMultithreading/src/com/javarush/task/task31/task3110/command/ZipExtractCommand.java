package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полный путь директории для разархивации:");
            String s = "D:\\hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task31";
            Path sourcePath = Paths.get(s);
            zipFileManager.extractAll(sourcePath);
            ConsoleHelper.writeMessage("Архив разархивирован.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя директории.");
        }
    }
}
