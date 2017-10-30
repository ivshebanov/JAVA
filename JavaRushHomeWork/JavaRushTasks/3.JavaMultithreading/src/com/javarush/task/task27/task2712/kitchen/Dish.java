package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();
        for (Dish dish : Dish.values()) {
            result.append(dish).append(", ");
        }
        result.delete(result.length()-2, result.length());
        return result.toString();
    }
}
