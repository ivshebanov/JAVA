package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import static com.javarush.task.task26.task2613.ConsoleHelper.askCurrencyCode;
import static com.javarush.task.task26.task2613.ConsoleHelper.getValidTwoDigits;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;

class DepositCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = askCurrencyCode();
        CurrencyManipulator cm = getManipulatorByCurrencyCode(currencyCode);
        String[] currencyValue = getValidTwoDigits(currencyCode);
        cm.addAmount(Integer.valueOf(currencyValue[0]), Integer.valueOf(currencyValue[1]));
    }
}
