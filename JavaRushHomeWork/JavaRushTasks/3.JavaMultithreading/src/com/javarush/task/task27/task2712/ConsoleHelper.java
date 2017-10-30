package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> resultListDish = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда.");
        String dish;
        while (!(dish = readString()).equals("exit")) {
            writeMessage("Введите название блюда.");
            try {
                if (Arrays.asList(Dish.values()).contains(Dish.valueOf(dish))) {
                    resultListDish.add(Dish.valueOf(dish));
                }
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блю да нет.");
            }
        }
        return resultListDish;
    }
}
