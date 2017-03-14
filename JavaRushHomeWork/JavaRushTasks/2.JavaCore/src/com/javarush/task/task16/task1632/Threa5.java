package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa5 implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        int count = 0;
        String check;
        try {
            while (!(check = reader.readLine()).equals("N")) {
                count = count + Integer.parseInt(check);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
