package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static java.lang.String.format;

public class LoginCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(format("%s.resources.login_en", CashMachine.class.getPackage().getName()), Locale.ENGLISH);
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(format("%s.resources.verifiedCards", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        String numberCard = "";
        while (true) {
            try {
                writeMessage(res.getString("specify.data"));
                numberCard = readString();
                String pin = readString();
                if (numberCard.isEmpty() || pin.isEmpty()) throw new IllegalArgumentException(res.getString("try.again.with.details"));
                if (Long.valueOf(numberCard) <= 0 || Integer.valueOf(pin) <= 0) throw new IllegalArgumentException(res.getString("try.again.with.details"));
                if (!validCreditCards.containsKey(numberCard)) throw new IllegalArgumentException(res.getString("try.again.with.details"));
                if (!validCreditCards.getString(numberCard).equals(pin)) throw new IllegalArgumentException(res.getString("try.again.or.exit"));
                writeMessage(format(res.getString("success.format"), numberCard));
                break;
            } catch (IllegalArgumentException e) {
                writeMessage(format(res.getString("not.verified.format"), numberCard));
                writeMessage(e.getMessage());
            }
        }
    }
}
