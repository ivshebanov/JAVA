package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage("Вы дейстрительно хотите выйти? <y,n>");
        try {
            if (readString().toLowerCase().equals("y")){
                writeMessage("Досвиданья.");
            }
        } catch (InterruptOperationException e) {
            throw new InterruptOperationException ();
        }
    }
}
