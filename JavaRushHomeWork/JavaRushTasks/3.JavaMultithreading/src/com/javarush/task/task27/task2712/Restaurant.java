package com.javarush.task.task27.task2712;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) {
        try {
            ConsoleHelper.writeMessage(ConsoleHelper.getAllDishesForOrder().toString());
        } catch (IOException e) {

        }
    }
}
