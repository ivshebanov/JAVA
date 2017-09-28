package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

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
