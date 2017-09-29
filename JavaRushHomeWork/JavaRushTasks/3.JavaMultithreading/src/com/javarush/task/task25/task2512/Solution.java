package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (thread != null) {
            thread.interrupt();
        }
        if (throwable.getCause() != null) {
            uncaughtException(thread, throwable.getCause());
        }
        String className = throwable.getClass().toString();
        System.out.println(className.substring(6, className.length())
                + ": " + throwable.getMessage());
    }

    public static void main(String[] args) {
        new Test(new Solution()).start();
    }


    static class Test extends Thread {
        private Thread.UncaughtExceptionHandler handler;

        public Test(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.handler = uncaughtExceptionHandler;
        }

        @Override
        public void run() {
            this.handler.uncaughtException(Thread.currentThread(),
                    new Exception("ABC",
                            new RuntimeException("DEF",
                                    new IllegalAccessException("GHI"))));
        }
    }
}
