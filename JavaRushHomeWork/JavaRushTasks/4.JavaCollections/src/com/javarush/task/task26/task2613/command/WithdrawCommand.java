package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;

import static com.javarush.task.task26.task2613.ConsoleHelper.askCurrencyCode;
import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static com.javarush.task.task26.task2613.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = askCurrencyCode();
        CurrencyManipulator cm = getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            writeMessage("Введите сумму.");
            String countMoneyString = readString();
            int countMoney;
            try {
                countMoney = Integer.valueOf(countMoneyString);
            } catch (NumberFormatException e) {
                writeMessage("Вы ввели некорректное число, попробуйте еще раз.");
                continue;
            }
            if (countMoney <= 0) {
                writeMessage("Вы ввели некорректное число, попробуйте еще раз.");
                continue;
            }
            if (!cm.isAmountAvailable(countMoney)) {
                writeMessage("На вашем счете недостаточно денег.");
                continue;
            }
            Map<Integer, Integer> withdrawAmount = null;
            try {
                withdrawAmount = cm.withdrawAmount(countMoney);
            } catch (NotEnoughMoneyException e) {
                writeMessage("В терменале не достаточно банкнот, введите другую сумму.");
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : withdrawAmount.entrySet()) {
                writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
            }
            writeMessage("Транзакция совершена успешно.");
            break;
        }
    }
}
