package com.javarush.task.task25.task2506;

/**
 * Created by Администратор on 23.03.2017.
 */
public class LoggingStateThread extends Thread {
    public Thread thread;
    private State che;

    LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.che = thread.getState();
        setDaemon(true);
        System.out.println(che);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (che != thread.getState()) {
                che = thread.getState();
                System.out.println(che);
            }
        }
    }
}
