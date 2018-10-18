package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getAllCurrencyManipulators;
import static java.lang.String.format;

class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.info_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() {
        boolean money = true;

        writeMessage(res.getString("before"));
        for (CurrencyManipulator entry : getAllCurrencyManipulators()) {
            if (entry.hasMoney()) {
                writeMessage(entry.getCurrencyCode().toUpperCase() + " - " + String.valueOf(entry.getTotalAmount()));
                money = false;
            }
        }
        if (money) writeMessage(res.getString("no.money"));
    }
}
