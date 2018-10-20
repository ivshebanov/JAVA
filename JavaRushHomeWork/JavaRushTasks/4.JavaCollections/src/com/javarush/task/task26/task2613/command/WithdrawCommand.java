package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.askCurrencyCode;
import static com.javarush.task.task26.task2613.ConsoleHelper.getValidNumber;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;
import static java.lang.String.format;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.withdraw_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        String askCurrencyCode = askCurrencyCode();
        CurrencyManipulator cm = getManipulatorByCurrencyCode(askCurrencyCode);
        while (true) {
            writeMessage(res.getString("specify.amount"));
            int countMoney = getValidNumber();
            try {
                if (!cm.isAmountAvailable(countMoney))
                    throw new NotEnoughMoneyException(res.getString("not.enough.money"));
                Map<Integer, Integer> withdrawAmount = cm.withdrawAmount(countMoney);
                for (Map.Entry<Integer, Integer> entry : withdrawAmount.entrySet()) {
                    writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                }
                writeMessage(format(res.getString("success.format"), countMoney, askCurrencyCode));
                break;
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                writeMessage(e.getMessage());
            }
        }
    }
}
