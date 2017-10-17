package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Создание архива.");
        try {
            ZipFileManager zfm = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации.");
//        String d = "D:\\hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task31\\task3110";

            zfm.createZip(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException ex) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
