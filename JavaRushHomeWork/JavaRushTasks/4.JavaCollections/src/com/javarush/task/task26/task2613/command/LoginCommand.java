package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

public class LoginCommand implements Command {

    private static final long NUMBER_CARD = 123456789012L;
    private static final int PIN = 1234;

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage("Введите 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр.");
        while (true) {
            try {
                long numberCard = Long.valueOf(readString());
                int pin = Integer.valueOf(readString());
                if (numberCard != NUMBER_CARD || pin != PIN) throw new IllegalArgumentException();
                writeMessage("Верификация прошла успешно.");
                break;
            } catch (IllegalArgumentException e) {
                writeMessage("Числа введены не корректено, попробуте еще раз.");
            }
        }
    }
}
