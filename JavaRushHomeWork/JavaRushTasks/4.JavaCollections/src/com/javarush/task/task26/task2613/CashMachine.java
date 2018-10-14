package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

import static com.javarush.task.task26.task2613.ConsoleHelper.askOperation;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.Operation.EXIT;
import static com.javarush.task.task26.task2613.Operation.LOGIN;

public class CashMachine {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        try {
            CommandExecutor.execute(LOGIN);
            do {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } while (operation != EXIT);
        } catch (InterruptOperationException e) {
            writeMessage("Досвиданья.");
        }

    }
}
