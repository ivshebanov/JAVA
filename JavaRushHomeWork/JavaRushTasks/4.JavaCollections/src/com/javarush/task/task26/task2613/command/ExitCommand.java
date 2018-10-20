package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static java.lang.String.format;

class ExitCommand implements Command {

    private static final String Y = "y";
    private ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.exit_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("exit.question.y.n"));
        try {
            if (readString().equalsIgnoreCase(Y)) {
                writeMessage(res.getString("thank.message"));
            }
        } catch (InterruptOperationException e) {
            throw new InterruptOperationException();
        }
    }
}
