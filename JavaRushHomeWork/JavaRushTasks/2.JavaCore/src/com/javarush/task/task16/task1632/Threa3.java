package com.javarush.task.task16.task1632;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa3 implements Runnable {

    @Override
    public void run() {
        try {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                System.out.println("Ура");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
