package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.Operation.getAllowableOperationByOrdinal;
import static java.lang.String.format;

public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.common_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static final String GOODBYE = res.getString("the.end");
    private static final String WHAT_OPERATION_DO_YOU_WANT_TO_PERFORM = "Какую операцию вы хотите выполнить?\n1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT";

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String readLine = "";
        try {
            readLine = bis.readLine();
            if (readLine.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {

        }
        return readLine;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        while (true) {
            String currencyCode = readString();
            if (!currencyCode.isEmpty() && currencyCode.toCharArray().length == 3) {
                return currencyCode.toUpperCase();
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static int getValidNumber() throws InterruptOperationException {
        int countMoney = Integer.valueOf(readString());
        if (countMoney <= 0) throw new IllegalArgumentException();
        return countMoney;

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true) {
            try {
                String faceValueAndAmountBanknotes = readString();
                if (faceValueAndAmountBanknotes.isEmpty()) throw new IllegalArgumentException();
                String[] resultArray = faceValueAndAmountBanknotes.split(" ");
                if (resultArray.length != 2) throw new IllegalArgumentException();
                Integer.valueOf(resultArray[0]);
                Integer.valueOf(resultArray[1]);
                return resultArray;
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage(WHAT_OPERATION_DO_YOU_WANT_TO_PERFORM);
        while (true) {
            try {
                return getAllowableOperationByOrdinal(Integer.valueOf(readString()));
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
