package com.javarush.task.task39.task3913;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogParserTest {

    private LogParser logParser;

    @Before
    public void beforeMethod() {
        String path = "/Users/iliashebanov/Documents/Java/JavaRush/JavaRushHomeWork/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/example.log";
        Path path1 = Paths.get(path);
        this.logParser = new LogParser(path1);
    }

    @Test
    public void getNumberOfUniqueIPs() {
        Date after = new Date();
        Date before = new Date();

        String dateAfter = "30.08.2012";
        String dateBefore = "19.03.2016";
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        try {
            after = formatForDateNow.parse(dateAfter);
            before = formatForDateNow.parse(dateBefore);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int currentResult = logParser.getNumberOfUniqueIPs(after, before);
        int correctResult = 3;

        Assert.assertEquals(correctResult, currentResult);
    }

    @Test
    public void getUniqueIPs() {
    }

    @Test
    public void getIPsForUser() {
    }

    @Test
    public void getIPsForEvent() {
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