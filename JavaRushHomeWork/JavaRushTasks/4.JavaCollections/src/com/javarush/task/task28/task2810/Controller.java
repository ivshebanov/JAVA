package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + (providers == null ? null : Arrays.asList(providers)) +
                '}';
    }

    public void scan() {
        List<Vacancy> resultList = new ArrayList<>();

        for (Provider provider : providers) {
            try {
                resultList.addAll(provider.getJavaVacancies("Москва"));
            } catch (NullPointerException e) {
                System.out.println("NPE");
                e.getStackTrace();
            }
        }
        System.out.println(resultList.size());
    }
}
