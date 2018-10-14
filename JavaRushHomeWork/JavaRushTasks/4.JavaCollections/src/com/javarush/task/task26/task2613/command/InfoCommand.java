package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;

import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getAllCurrencyManipulators;

class InfoCommand implements Command {

    @Override
    public void execute() {
        boolean money = true;

        for (CurrencyManipulator entry : getAllCurrencyManipulators()) {
            if (entry.hasMoney()) {
                writeMessage(entry.getCurrencyCode().toUpperCase() + " - " + String.valueOf(entry.getTotalAmount()));
                money = false;
            }
        }
        if (money) {
            writeMessage("No money available.");
        }
    }
}
