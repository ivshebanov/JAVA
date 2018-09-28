package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum enu) {
        if (enu != null) {
            String message = enu.name().charAt(0) + enu.name().substring(1).toLowerCase().replace("_", " ");

            if (enu instanceof ExceptionDBMessage) {
                return new RuntimeException(message);
            }
            if (enu instanceof ExceptionUserMessage) {
                return new Error(message);
            }
            if (enu instanceof ExceptionApplicationMessage) {
                return new Exception(message);
            }
        }
        return new IllegalArgumentException();
    }
}
