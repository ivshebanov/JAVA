package com.javarush.task.task28.task2805;

import javafx.scene.layout.Priority;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    AtomicInteger factoryNumber = new AtomicInteger(1);
    static AtomicInteger factoryCount = new AtomicInteger(1);

    public MyThread() {
        if (factoryCount.get() > 10) {
            factoryCount.set(1);
            factoryNumber.set(factoryCount.get());
        }
        factoryNumber.set(factoryCount.getAndIncrement());
        this.setPriority(factoryNumber.get());
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
