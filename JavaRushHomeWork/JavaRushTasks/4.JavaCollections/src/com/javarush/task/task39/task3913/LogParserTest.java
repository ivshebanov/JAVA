package com.javarush.task.task39.task3913;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LogParserTest {

    private static final String DATE_AFTER = "30.08.2012";
    private static final String DATE_BEFORE = "19.03.2016";
    private static final String USER = "Eduard Petrovich Morozko";

    private LogParser logParser;
    private Date after;
    private Date before;

    @Before
    public void beforeMethod() {
        String path = "/Users/iliashebanov/Documents/Java/JavaRush/JavaRushHomeWork/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/example.log";
        Path path1 = Paths.get(path);
        this.logParser = new LogParser(path1);

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.after = formatForDateNow.parse(DATE_AFTER);
            this.before = formatForDateNow.parse(DATE_BEFORE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNumberOfUniqueIPs() {
        int currentResult = logParser.getNumberOfUniqueIPs(after, before);
        int correctResult = 3;
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getUniqueIPs() {
        Set<String> currentResult = logParser.getUniqueIPs(after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForUser() {
        Set<String> currentResult = logParser.getIPsForUser(USER, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForEvent() {
        Set<String> currentResult = logParser.getIPsForEvent(Event.WRITE_MESSAGE, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForStatus() {
    }

//    @Test
//    public void getDate() {
//        String date = "30.08.2012";
//        String time = "16:08:13";
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//        Date testDate = null;
//        try {
//            testDate = formatForDateNow.parse(date + " " + time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date resultDate = logParser.getDate(date, time);
//        System.out.println(testDate);
//        System.out.println(resultDate);
//        Assert.assertEquals(testDate, resultDate);
//    }
}