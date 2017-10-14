package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите полный пусть для архива.");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(bufferedReader.readLine()));
            System.out.println("Введите путь к файлу, который будем архивировать.");
            zipFileManager.createZip(Paths.get(bufferedReader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
