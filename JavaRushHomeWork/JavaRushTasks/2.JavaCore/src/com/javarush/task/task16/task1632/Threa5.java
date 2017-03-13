package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 13.03.2017.
 */
public class Threa5 implements Runnable {

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
