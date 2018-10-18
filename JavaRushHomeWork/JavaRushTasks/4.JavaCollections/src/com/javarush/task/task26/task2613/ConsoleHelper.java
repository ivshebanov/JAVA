package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.task.task26.task2613.Operation.getAllowableOperationByOrdinal;
import static java.lang.String.format;

public class ConsoleHelper {

    public static final String Y = "y";
    public static final String EXIT = "exit";
    public static final String GOODBYE = "Досвиданья.";
    public static final String NUMBER_OF_ENUM_EXCEEDED = "Превышено колличество enum.";
    public static final String TRANSACTION_WAS_COMPLETED_SUCCESSFULLY = "Транзакция совершена успешно.";
    public static final String THERE_IS_NOT_ENOUGH_MONEY_IN_YOUR_ACCOUNT = "На вашем счете недостаточно денег.";
    public static final String WHAT_OPERATION_DO_YOU_WANT_TO_PERFORM = "Какую операцию вы хотите выполнить?\n1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT";
    public static final String ENTER_AMOUNT = "Введите сумму.";
    public static final String ENTER_CURRENCY_CODE = "Введите код валюты.";
    public static final String ENTER_TWO_POSITIVE_INTEGERS = "Введите два целых положительных числа для валюты %s.\nПервое число - номинал, второе - количество банкнот.";
    public static final String REQUEST_CARD_NUMBER_AND_PIN = "Введите 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр.";
    public static final String YOU_ENTERED_AN_INCORRECT_NUMBER = "Вы ввели некорректное число, попробуйте еще раз.";
    public static final String VERIFICATION_PASSED_SUCCESSFULLY = "Верификация прошла успешно.";
    public static final String THERE_ARE_NO_BANKNOTES_IN_THE_ATM = "В терменале не достаточно банкнот, введите другую сумму.";
    public static final String YOU_HAVE_NOT_ENTERED_ONE_OF_THE_NUMBERS = "Вы не ввели одно из чисел.";
    public static final String THE_ENTERED_CURRENCY_CODE_IS_NOT_CORRECT = "Введенный код валюты не корректен, попробуте еще раз.";
    public static final String NUMBER_ENTERED_NOT_CORRECT = "Число введено не корректено, попробуте еще раз.";
    public static final String NUMBERS_CANNOT_BE_NEGATIVE = "Числа не могут быть отрицательными.";
    public static final String NUMBERS_ENTERED_NOT_CORRECT = "Числа введены не корректено, попробуте еще раз.";

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String readLine = "";
        try {
            readLine = bis.readLine();
            if (readLine.equalsIgnoreCase(EXIT)) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {

        }
        return readLine;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(ENTER_CURRENCY_CODE);
        while (true) {
            String currencyCode = readString();
            if (!currencyCode.isEmpty() && currencyCode.toCharArray().length == 3) {
                return currencyCode.toUpperCase();
            }
            writeMessage("Please specify valid data.");
        }
    }

    public static int getValidNumber() throws InterruptOperationException {
        writeMessage(ENTER_AMOUNT);
        while (true) {
            try {
                int countMoney = Integer.valueOf(readString());
                if (countMoney <= 0) throw new IllegalArgumentException(YOU_ENTERED_AN_INCORRECT_NUMBER);
                return countMoney;
            } catch (NumberFormatException e) {
                writeMessage(YOU_ENTERED_AN_INCORRECT_NUMBER);
            } catch (IllegalArgumentException e) {
                writeMessage(e.getMessage());
            }
        }
    }

    public static String[] getValidNumberCardAndPin() throws InterruptOperationException {
        writeMessage(REQUEST_CARD_NUMBER_AND_PIN);
        while (true) {
            try {
                String numberCard = readString();
                String pin = readString();
                if (numberCard.isEmpty() || pin.isEmpty()) throw new IllegalArgumentException(YOU_HAVE_NOT_ENTERED_ONE_OF_THE_NUMBERS);
                Long numberCardInt = Long.valueOf(numberCard);
                int pinInt = Integer.valueOf(pin);
                if (numberCardInt <= 0 || pinInt <= 0) throw new IllegalArgumentException(NUMBERS_CANNOT_BE_NEGATIVE);
                return new String[]{numberCard, pin};
            } catch (NumberFormatException e) {
                writeMessage(NUMBERS_ENTERED_NOT_CORRECT);
            } catch (IllegalArgumentException e) {
                writeMessage(e.getMessage());
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(format(ENTER_TWO_POSITIVE_INTEGERS, currencyCode));
        while (true) {
            try {
                String faceValueAndAmountBanknotes = readString();
                if (faceValueAndAmountBanknotes.isEmpty()) throw new IllegalArgumentException("");
                String[] resultArray = faceValueAndAmountBanknotes.split(" ");
                if (resultArray.length != 2) throw new IllegalArgumentException("");
                Integer.valueOf(resultArray[0]);
                Integer.valueOf(resultArray[1]);
                return resultArray;
            } catch (NumberFormatException e) {
                writeMessage("");
            } catch (IllegalArgumentException e) {
                writeMessage(e.getMessage());
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(WHAT_OPERATION_DO_YOU_WANT_TO_PERFORM);
        while (true) {
            try {
                return getAllowableOperationByOrdinal(Integer.valueOf(readString()));
            } catch (NumberFormatException e) {
                writeMessage(NUMBER_ENTERED_NOT_CORRECT);
            } catch (IllegalArgumentException e) {
                writeMessage(YOU_ENTERED_AN_INCORRECT_NUMBER);
            }
        }
    }
}
