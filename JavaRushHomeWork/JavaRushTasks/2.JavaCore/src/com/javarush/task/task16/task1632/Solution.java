package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
//        Threa1 threa1 = new Threa1();
//        Thread thread1 = new Thread(threa1);
        threads.add(new Thread(new Threa1()));
        threads.add(new Thread(new Threa2()));
        threads.add(new Thread(new Threa3()));
        threads.add(new Thread(new Threa4()));
        threads.add(new Thread(new Threa5()));
    }
    public static void main(String[] args) {
        threads.get(3).start();
    }
}