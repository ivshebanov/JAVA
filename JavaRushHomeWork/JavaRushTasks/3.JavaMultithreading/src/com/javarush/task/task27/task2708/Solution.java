package com.javarush.task.task27.task2708;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Set;

/* 
Убираем deadLock используя открытые вызовы
*/
public class Solution {
    public static void main(String[] args) {
        final long deadLineTime = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate();
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true);
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < deadLineTime)
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("The dead lock occurred");
            }
        });

        deamonThread.setDaemon(true);
        deamonThread.start();

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlock = threadMXBean.findDeadlockedThreads();
        if (deadlock != null) {
            ThreadInfo[] th = threadMXBean.getThreadInfo(deadlock);
            for (ThreadInfo info : th) {
                System.out.println(info);
            }
        }
    }
}