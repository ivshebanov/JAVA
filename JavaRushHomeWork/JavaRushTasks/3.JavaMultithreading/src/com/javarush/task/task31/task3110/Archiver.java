package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try {
            ConsoleHelper.writeMessage("Введите полный пусть для архива.");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Введите путь к файлу, который будем архивировать.");
            zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));
            Operation operation = null;
            while (operation != Operation.EXIT) {
                try {
                    operation = askOperation();
                    CommandExecutor.execute(operation);
                } catch (WrongZipFileException ex) {
                    ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
                } catch (Exception ex) {
                    ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Operation askOperation() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите операцию:\n").
                append(Operation.CREATE.ordinal()).append(" - упаковать файлы в архив\n").
                append(Operation.ADD.ordinal()).append(" - добавить файл в архив\n").
                append(Operation.REMOVE.ordinal()).append(" - удалить файл из архива\n").
                append(Operation.EXTRACT.ordinal()).append(" - распаковать архив\n").
                append(Operation.CONTENT.ordinal()).append(" - просмотреть содержимое архива\n").
                append(Operation.EXIT.ordinal()).append(" – выход");
        ConsoleHelper.writeMessage(sb.toString());
        int numberOperation = ConsoleHelper.readInt();
        Operation[] operation = Operation.values();
        return operation[numberOperation];
    }
}
