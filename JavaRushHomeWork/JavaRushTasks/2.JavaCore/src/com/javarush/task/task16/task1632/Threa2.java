package com.javarush.task.task16.task1632;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa2 implements Runnable {
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
