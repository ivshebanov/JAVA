package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long startTime = new Date().getTime();
        for (String el : strings) {
            ids.add(shortener.getId(el));
        }
        return new Date().getTime() - startTime;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long startTime = new Date().getTime();
        for (Long el : ids) {
            strings.add(shortener.getString(el));
        }
        return new Date().getTime() - startTime;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> origLong1 = new HashSet<>();
        Set<Long> origLong2 = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Long time11 = getTimeForGettingIds(shortener1, origStrings, origLong1);
        Long time12 = getTimeForGettingIds(shortener2, origStrings, origLong2);
        Assert.assertTrue(time11 > time12);

        Long time21 = getTimeForGettingStrings(shortener1, origLong1, origStrings);
        Long time22 = getTimeForGettingStrings(shortener2, origLong2, origStrings);

        Assert.assertEquals(time21, time22, 30);
    }
}
