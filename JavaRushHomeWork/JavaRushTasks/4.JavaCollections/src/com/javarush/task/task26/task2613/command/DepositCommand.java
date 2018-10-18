package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.askCurrencyCode;
import static com.javarush.task.task26.task2613.ConsoleHelper.getValidTwoDigits;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;
import static java.lang.String.format;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.deposit_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        String currencyCode = askCurrencyCode();
        CurrencyManipulator cm = getManipulatorByCurrencyCode(currencyCode);
        String[] currencyValue = getValidTwoDigits(currencyCode);

        try {
            int k = Integer.parseInt(currencyValue[0]);
            int l = Integer.parseInt(currencyValue[1]);
            cm.addAmount(k, l);
            writeMessage(String.format(res.getString("success.format"), k * l, currencyCode));
        } catch (NumberFormatException ex) {
            writeMessage(res.getString("invalid.data"));
        }
    }
}
