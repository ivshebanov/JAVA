package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution,
                                            final Object o1, final Object o2)
            throws Exception {
        Thread thread1;
        Thread thread2;
        synchronized (o1) {
            //do something here
            thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            });

            thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o2) {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            System.out.println(thread1.getState());
            thread1.start();
            System.out.println(thread1.getState());

            System.out.println(thread2.getState());
            thread2.start();
            System.out.println(thread2.getState());
            Thread.sleep(20);
            System.out.println(thread2.getState());
        }
        Thread.sleep(5);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        boolean bol = thread1.getState().equals(Thread.State.BLOCKED);

        return bol;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
