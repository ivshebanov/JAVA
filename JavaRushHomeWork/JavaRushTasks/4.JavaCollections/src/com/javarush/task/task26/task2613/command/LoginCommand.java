package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.ConsoleHelper.NUMBERS_ENTERED_NOT_CORRECT;
import static com.javarush.task.task26.task2613.ConsoleHelper.VERIFICATION_PASSED_SUCCESSFULLY;
import static com.javarush.task.task26.task2613.ConsoleHelper.getValidNumberCardAndPin;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;
import static java.lang.String.format;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(format("%s.resources.verifiedCards", CashMachine.class.getPackage().getName()), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            try {
                String[] numberCardAndPin = getValidNumberCardAndPin();
                String numberCard = numberCardAndPin[0];
                String pin = numberCardAndPin[1];
                if (!validCreditCards.containsKey(numberCard) || !validCreditCards.getString(numberCard).equals(pin))
                    throw new IllegalArgumentException(NUMBERS_ENTERED_NOT_CORRECT);
                writeMessage(VERIFICATION_PASSED_SUCCESSFULLY);
                break;
            } catch (IllegalArgumentException e) {
                writeMessage(e.getMessage());
            }
        }
    }
}
