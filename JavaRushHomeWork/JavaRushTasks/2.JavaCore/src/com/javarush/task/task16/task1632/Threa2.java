package com.javarush.task.task16.task1632;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
