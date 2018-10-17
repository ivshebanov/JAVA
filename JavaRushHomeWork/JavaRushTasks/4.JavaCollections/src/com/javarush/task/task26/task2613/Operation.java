package com.javarush.task.task26.task2613;

import static com.javarush.task.task26.task2613.ConsoleHelper.NUMBER_OF_ENUM_EXCEEDED;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW, //ИЗЫМАТЬ
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        switch (i) {
            case 0: throw new IllegalArgumentException();
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            default: throw new IllegalArgumentException(NUMBER_OF_ENUM_EXCEEDED);
        }
    }
}
