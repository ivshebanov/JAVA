package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import static com.javarush.task.task26.task2613.ConsoleHelper.DO_YOU_REALLY_WANT_TO_GO_OUT;
import static com.javarush.task.task26.task2613.ConsoleHelper.GOODBYE;
import static com.javarush.task.task26.task2613.ConsoleHelper.Y;
import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(DO_YOU_REALLY_WANT_TO_GO_OUT);
        try {
            if (readString().equalsIgnoreCase(Y)) {
                writeMessage(GOODBYE);
            }
        } catch (InterruptOperationException e) {
            throw new InterruptOperationException();
        }
    }
}
