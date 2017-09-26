package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    /**
     * В конструкторе мы описываем обработчик исключений, который установлен для класса Solution.
     */
    public Solution() {
        setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                if (throwable instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (throwable instanceof Exception) {
                    System.out.println("Надо обработать");
                } else {
                    System.out.println("ХЗ");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Solution().start();
    }

    @Override
    public void run() {
        throw new Error();
    }
}
