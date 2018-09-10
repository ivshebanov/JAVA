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
    private static final String USER_EPM = "Eduard Petrovich Morozko";
    private static final String USER_VP = "Vasya Pupkin";

    private LogParser logParser;
    private Date after;
    private Date before;
    private Date afterNull = null;
    private Date beforeNull = null;

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
    public void getNumberOfUniqueIPs_DATES_NULL() {
        int currentResult = logParser.getNumberOfUniqueIPs(afterNull, beforeNull);
        int correctResult = 5;
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
    public void getUniqueIPs_NO_NULL() {
        Set<String> currentResult = logParser.getUniqueIPs(after, before);
        Assert.assertNotNull(currentResult);
    }

    @Test
    public void getUniqueIPs_DATES_NULL() {
        Set<String> currentResult = logParser.getUniqueIPs(afterNull, beforeNull);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        correctResult.add("120.120.120.122");
        correctResult.add("12.12.12.12");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForUser() {
        Set<String> currentResult = logParser.getIPsForUser(USER_EPM, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForUser_NO_NULL() {
        Set<String> currentResult = logParser.getIPsForUser(USER_EPM, after, before);
        Assert.assertNotNull(currentResult);
    }

    @Test
    public void getIPsForUser_DATES_NULL() {
        Set<String> currentResult = logParser.getIPsForUser(USER_VP, afterNull, beforeNull);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
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
    public void getIPsForEvent_NO_NULL() {
        Set<String> currentResult = logParser.getIPsForEvent(Event.WRITE_MESSAGE, after, before);
        Assert.assertNotNull(currentResult);
    }

    @Test
    public void getIPsForEvent_DATES_NULL() {
        Set<String> currentResult = logParser.getIPsForEvent(Event.SOLVE_TASK, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
        Assert.assertEquals(correctResult, currentResult);
    }


    @Test
    public void getIPsForStatus() {
        Set<String> currentResult = logParser.getIPsForStatus(Status.OK, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
        correctResult.add("146.34.15.5");
        correctResult.add("127.0.0.1");
        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getIPsForStatus_NO_NULL() {
        Set<String> currentResult = logParser.getIPsForStatus(Status.OK, after, before);
        Assert.assertNotNull(currentResult);
    }

    @Test
    public void getIPsForStatus_DATES_NULL() {
        Set<String> currentResult = logParser.getIPsForStatus(Status.ERROR, after, before);
        Set<String> correctResult = new HashSet<>();
        correctResult.add("192.168.100.2");
        Assert.assertEquals(correctResult, currentResult);
    }
}