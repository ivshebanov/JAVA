package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(thread.getName())) {
            System.out.println(getFormattedStringForFirstThread(thread, throwable, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(thread.getName())) {
            System.out.println(getFormattedStringForSecondThread(thread, throwable, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(thread, throwable, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread thread,
                                                      Throwable throwable, String string) {
        return String.format(string, throwable.getClass().getSimpleName(),
                throwable.getCause(), thread.getName());
    }

    protected String getFormattedStringForSecondThread(Thread thread,
                                                       Throwable throwable, String string) {
        return String.format(string, throwable.getCause(),
                throwable.getClass().getSimpleName(), thread.getName());
    }

    protected String getFormattedStringForFirstThread(Thread thread,
                                                      Throwable throwable, String string) {
        return String.format(string, thread.getName(),
                throwable.getClass().getSimpleName(), throwable.getCause());
    }
}

