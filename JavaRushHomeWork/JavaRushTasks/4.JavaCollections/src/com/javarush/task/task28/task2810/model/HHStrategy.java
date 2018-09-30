package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    String url = String.format(URL_FORMAT, "Kiev", 3);


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> resultList = new ArrayList<>();
        return resultList;
    }
}
