package com.javarush.task.task28.task2810.model;

public class HHStrategy implements Strategy {
    //"http://hh.ua/search/vacancy?text=java+Kiev&page=3"

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    String url = String.format(URL_FORMAT, "Kiev", 3);
}
