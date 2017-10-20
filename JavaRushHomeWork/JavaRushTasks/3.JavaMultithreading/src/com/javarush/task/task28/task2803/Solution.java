package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble(0, 1);
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getRandomIntegerBetweenNumbers(1, 100));
            System.out.println(getRandomDouble());
            System.out.println(getRandomLongBetween0AndN(300000000));
            System.out.println();
        }
    }
}
