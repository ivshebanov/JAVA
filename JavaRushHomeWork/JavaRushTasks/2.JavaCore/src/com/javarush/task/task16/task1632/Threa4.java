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

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()){
            System.out.println("1");
        }
    }
}
