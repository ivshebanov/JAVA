package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    ///Users/iliashebanov/Documents/JAVA/JavaRushHomeWork/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task31/task3110/arh.zip
    ///Users/iliashebanov/Documents/JAVA/JavaRushHomeWork/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task31/task3110/Archiver.docx

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ConsoleHelper.writeMessage("Введите полный пусть для архива.");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(bufferedReader.readLine()));
            ConsoleHelper.writeMessage("Введите путь к файлу, который будем архивировать.");
            zipFileManager.createZip(Paths.get(bufferedReader.readLine()));


            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
