package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        final AtomicInteger factoryNumber = new AtomicInteger(1);
        final AtomicInteger threadNumber = new AtomicInteger(1);
        static AtomicInteger factoryCount = new AtomicInteger(1);

        public AmigoThreadFactory() {
            factoryNumber.set(factoryCount.getAndIncrement());
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            if (thread.isDaemon())
                thread.setDaemon(false);

            if (thread.getPriority() != Thread.NORM_PRIORITY)
                thread.setPriority(Thread.NORM_PRIORITY);

            thread.setName(String.format("%s-pool-%s-thread-%s", thread.getThreadGroup().getName(), factoryNumber, threadNumber.getAndIncrement()));
            return thread;
        }
    }
}

