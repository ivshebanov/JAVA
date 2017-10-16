package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try {
            ConsoleHelper.writeMessage("Введите полный пусть для архива.");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Введите путь к файлу, который будем архивировать.");
            zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));


            CommandExecutor.execute(Operation.EXIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
