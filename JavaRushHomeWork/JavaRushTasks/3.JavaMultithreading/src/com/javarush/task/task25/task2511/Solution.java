package com.javarush.task.task25.task2511;

import javafx.beans.binding.StringBinding;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    /**
     * В конструкторе анонимный клас обработки всех ошибок.
     */
    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        class MyCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
//                System.out.println(throwable.toString());
                String nameThread = thread.getName().replaceAll(".", "*");
                System.out.print(throwable.toString().replace(thread.getName(), nameThread));
//                int nameThreadLength = thread.getName().length();
//                StringBuilder nameThread = new StringBuilder();
//                for (int i = 0; i < nameThreadLength; i++) {
//                    nameThread.append("*");
//                }
//                String[] resultArr = throwable.toString().split(" ");
//                StringBuilder sb = new StringBuilder();
//                sb.append(resultArr[0]).append(" ").append(resultArr[1]).append(" ")
//                        .append(nameThread).append(" ").append(resultArr[3]);
//                System.out.println(sb);
            }
        }//init handler here
        this.handler = new MyCaughtExceptionHandler();
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah "
                    + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        TimerTask solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });
        solution.run();
    }
}