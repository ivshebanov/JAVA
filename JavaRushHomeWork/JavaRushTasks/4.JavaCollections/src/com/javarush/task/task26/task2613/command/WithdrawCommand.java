package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;

import static com.javarush.task.task26.task2613.ConsoleHelper.THERE_IS_NOT_ENOUGH_MONEY_IN_YOUR_ACCOUNT;
import static com.javarush.task.task26.task2613.ConsoleHelper.TRANSACTION_WAS_COMPLETED_SUCCESSFULLY;
import static com.javarush.task.task26.task2613.ConsoleHelper.askCurrencyCode;
import static com.javarush.task.task26.task2613.ConsoleHelper.getValidNumber;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        CurrencyManipulator cm = getManipulatorByCurrencyCode(askCurrencyCode());
        while (true) {
            int countMoney = getValidNumber();
            try {
                if (!cm.isAmountAvailable(countMoney)) throw new NotEnoughMoneyException(THERE_IS_NOT_ENOUGH_MONEY_IN_YOUR_ACCOUNT);
                Map<Integer, Integer> withdrawAmount = cm.withdrawAmount(countMoney);
                for (Map.Entry<Integer, Integer> entry : withdrawAmount.entrySet()) {
                    writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                }
                writeMessage(TRANSACTION_WAS_COMPLETED_SUCCESSFULLY);
                break;
            } catch (NotEnoughMoneyException e) {
                writeMessage(e.getMessage());
            }
        }
    }
}
