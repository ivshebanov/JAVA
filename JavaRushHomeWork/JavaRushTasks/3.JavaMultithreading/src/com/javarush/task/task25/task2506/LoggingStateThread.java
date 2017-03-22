package com.javarush.task.task25.task2506;

/**
 * Created by Администратор on 22.03.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread target) {
        this.thread = target;
        setDaemon(true);
        System.out.println(State.NEW);
    }

    @Override
    public void run() {
        State neSte=State.NEW;
        while (!isInterrupted()) {
            if (neSte != thread.getState()) {
                neSte = thread.getState();
                System.out.println(neSte);
            }
        }
    }
}
