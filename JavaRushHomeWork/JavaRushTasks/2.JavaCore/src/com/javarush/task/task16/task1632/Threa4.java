package com.javarush.task.task16.task1632;

import static com.javarush.task.task16.task1632.Solution.threads;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa4 implements Message, Runnable {

    @Override
    public void showWarning() {
        threads.get(3).interrupt();
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()){
            System.out.println("1");
        }
    }
}
