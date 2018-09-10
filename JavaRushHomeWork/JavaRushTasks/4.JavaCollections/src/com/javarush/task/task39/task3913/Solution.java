package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("/Users/iliashebanov/Documents/Java/JavaRush/JavaRushHomeWork/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getUniqueIPs( new Date(), null));
        System.out.println(logParser.getIPsForUser("Vasya Pupkin", null, null));
        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, null, null));
        System.out.println(logParser.getIPsForStatus(Status.ERROR, null, null));
    }
}