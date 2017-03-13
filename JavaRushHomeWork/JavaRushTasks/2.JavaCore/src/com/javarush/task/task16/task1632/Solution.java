package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    {
        threads.add(new Threa1());
        threads.add(new Threa2());
        threads.add(new Threa3());
        threads.add(new Threa4());
        threads.add(new Threa5());
    }
    public static void main(String[] args) {

    }

    public class Threa1 extends Thread{
        @Override
        public void run() {
            while (true);
        }
    }

    public class Threa2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(50000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public class Threa3 extends Thread {
        @Override
        public void run() {
            try {
                while (true){
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Threa4 extends Thread implements Message {

        @Override
        public void showWarning() {
            this.interrupt();
        }
        @Override
        public void run() {
            super.run();
        }
    }

    public class Threa5 extends Thread {
        @Override
        public void run() {
            try {
                ArrayList<Integer> array = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (!isInterrupted()){
                    String read = reader.readLine();
                    if (read.equals("N")){
                        int sum=0;
                        for (int i=0; i<array.size(); i++){
                            sum+=array.get(i);
                        }
                        System.out.println(sum);
                    } else {
                        array.add(Integer.parseInt(read));
                    }
                }
            } catch (IOException e){}
        }
    }
}