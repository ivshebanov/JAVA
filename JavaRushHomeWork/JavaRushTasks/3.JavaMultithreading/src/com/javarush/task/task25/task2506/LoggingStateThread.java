package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (state != State.TERMINATED) {
            if (state != target.getState()) {
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
