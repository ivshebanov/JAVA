package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.task.task26.task2613.Operation.getAllowableOperationByOrdinal;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String readLine = "";
        try {
            readLine = bis.readLine();
            if (readLine.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {

        }
        return readLine;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Введите код валюты.");
        while (true) {
            String currencyCode = readString();
            if (!currencyCode.isEmpty() && currencyCode.toCharArray().length == 3) {
                return currencyCode.toUpperCase();
            }
            writeMessage("Введенный код валюты не корректен, попробуте еще раз.");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Введите два целых положительных числа для валюты " + currencyCode + ".\n" +
                "Первое число - номинал, второе - количество банкнот.");

        while (true) {
            String faceValueAndAmountBanknotes = readString();
            if (!faceValueAndAmountBanknotes.isEmpty()) {
                String[] resultArray = faceValueAndAmountBanknotes.split(" ");
                if (resultArray.length == 2) {
                    try {
                        Integer.valueOf(resultArray[0]);
                        Integer.valueOf(resultArray[1]);
                    } catch (NumberFormatException e) {
                        writeMessage("Числа введены не корректено, попробуте еще раз.");
                        continue;
                    }
                }
                if (resultArray.length != 2) {
                    writeMessage("Числа введены не корректено, попробуте еще раз.");
                    continue;
                }
                return resultArray;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage("Какую операцию вы хотите выполнить?\n" +
                "1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        while (true) {
            String operation = readString();
            int numberOperation = Integer.valueOf(operation);
            try {
                if (numberOperation == 0) throw new IllegalArgumentException();
                return getAllowableOperationByOrdinal(numberOperation);
            } catch (IllegalArgumentException e) {
                writeMessage("Вы ввели некорректное число, попробуйте еще раз.");
            }
        }
    }
}
