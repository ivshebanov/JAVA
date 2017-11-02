package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Удаление файлa из архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Какой файл удалить?");
            String s = "PathIsNotFoundException.java";
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(destinationPath);
            ConsoleHelper.writeMessage("Файл был удален.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Неверный путь.");
        }
    }
}
