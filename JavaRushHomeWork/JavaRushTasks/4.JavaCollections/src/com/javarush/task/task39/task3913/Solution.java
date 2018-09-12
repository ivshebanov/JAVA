package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("/Users/iliashebanov/Documents/Java/JavaRush/JavaRushHomeWork/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date after = new Date(0);
        Date before = null;
        try {
            after = formatForDateNow.parse("30.08.2012 16:08:40");
            before = formatForDateNow.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(logParser.getNumberOfUniqueIPs(after, before));
//        System.out.println(logParser.getUniqueIPs(after, before));
//        System.out.println(logParser.getIPsForUser("Amigo", after, before));
//        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, after, before));
//        System.out.println(logParser.getIPsForStatus(Status.ERROR, after, before));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, null));
        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin", null, null));
    }
}