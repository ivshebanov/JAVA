package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.askOperation;
import static com.javarush.task.task26.task2613.ConsoleHelper.printExitMessage;
import static com.javarush.task.task26.task2613.Operation.EXIT;
import static com.javarush.task.task26.task2613.Operation.LOGIN;

public class CashMachine {

    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + ".common_en", Locale.ENGLISH);
        Operation operation;
        try {
            CommandExecutor.execute(LOGIN);
            ConsoleHelper.writeMessage(res.getString("write.help") + "\n");
            do {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } while (operation != EXIT);
        } catch (InterruptOperationException e) {
            printExitMessage();
        }
    }
}
