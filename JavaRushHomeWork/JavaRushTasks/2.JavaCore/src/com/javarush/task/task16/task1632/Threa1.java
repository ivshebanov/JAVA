package com.javarush.task.task16.task1632;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa1 implements Runnable{

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (current.isInterrupted()){

        }
    }
}
