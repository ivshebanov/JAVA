package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 1000);
        testStrategy(new OurHashMapStorageStrategy(), 1000);
        testStrategy(new FileStorageStrategy(), 1000);
        testStrategy(new OurHashBiMapStorageStrategy(), 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> resultSet = new HashSet<>();
        for (String str : strings) {
            resultSet.add(shortener.getId(str));
        }
        return resultSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> resultSet = new HashSet<>();
        for (Long id : keys) {
            resultSet.add(shortener.getString(id));
        }
        return resultSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        String nameStrategy = strategy.getClass().getName();
        Helper.printMessage(nameStrategy.substring(nameStrategy.lastIndexOf(".") + 1, nameStrategy.length()));
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        long startTime = new Date().getTime();
        Set<Long> setIds = getIds(shortener, strings);
        long estimatedTime = new Date().getTime() - startTime;
        Helper.printMessage(Long.toString(estimatedTime));

        long startTime1 = new Date().getTime();
        Set<String> setStrings = getStrings(shortener, setIds);
        long estimatedTime1 = new Date().getTime() - startTime1;
        Helper.printMessage(Long.toString(estimatedTime1));

        Helper.printMessage(setStrings.size() == strings.size() ? "Тест пройден." : "Тест не пройден.");
    }
}
