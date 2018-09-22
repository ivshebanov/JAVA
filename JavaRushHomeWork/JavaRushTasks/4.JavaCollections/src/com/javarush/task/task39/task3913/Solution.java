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
        Date before2 = null;
        try {
            after = formatForDateNow.parse("30.08.2012 16:08:40");
            before = formatForDateNow.parse("05.01.2021 20:22:55");
            before2 = formatForDateNow.parse("12.12.2013 21:56:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("getNumberOfUniqueIPs \t" + logParser.getNumberOfUniqueIPs(after, before));
        System.out.println("getUniqueIPs \t" + logParser.getUniqueIPs(after, before));
        System.out.println("getIPsForUser \t" + logParser.getIPsForUser("Amigo", after, before));
        System.out.println("getIPsForEvent \t" + logParser.getIPsForEvent(Event.DONE_TASK, after, before));
        System.out.println("getIPsForStatus \t" + logParser.getIPsForStatus(Status.ERROR, after, before));
        System.out.println();
        System.out.println("getAllUsers \t" + logParser.getAllUsers());
        System.out.println("getNumberOfUsers \t" + logParser.getNumberOfUsers(null, null));
        System.out.println("getNumberOfUserEvents \t" + logParser.getNumberOfUserEvents("Vasya Pupkin", null, null));
        System.out.println("getUsersForIP \t" + logParser.getUsersForIP("127.0.0.1", null, null));
        System.out.println("getLoggedUsers \t" + logParser.getLoggedUsers(null, null));
        System.out.println("getDownloadedPluginUsers \t" + logParser.getDownloadedPluginUsers(null, null));
        System.out.println("getWroteMessageUsers \t" + logParser.getWroteMessageUsers(null, null));
        System.out.println("getSolvedTaskUsers \t" + logParser.getSolvedTaskUsers(null, null));
        System.out.println("getSolvedTaskUsers \t" + logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println("getDoneTaskUsers \t" + logParser.getDoneTaskUsers(null, null));
        System.out.println("getDoneTaskUsers \t" + logParser.getDoneTaskUsers(null, null, 15));
        System.out.println();
        System.out.println("getDatesForUserAndEvent \t" + logParser.getDatesForUserAndEvent("Amigo", Event.SOLVE_TASK, null, null));
        System.out.println("getDatesWhenSomethingFailed \t" + logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println("getDatesWhenErrorHappened \t" + logParser.getDatesWhenErrorHappened(null, null));
        System.out.println("getDateWhenUserLoggedFirstTime \t" + logParser.getDateWhenUserLoggedFirstTime("Vasya Pupkin", null, null));
        System.out.println("getDateWhenUserSolvedTask \t" + logParser.getDateWhenUserSolvedTask("Vasya Pupkin", 18, null, null));
        System.out.println("getDateWhenUserDoneTask \t" + logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null));
        System.out.println("getDatesWhenUserWroteMessage \t" + logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko", null, null));
        System.out.println("getDatesWhenUserDownloadedPlugin \t" + logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko", null, null));
        System.out.println();
        System.out.println("getNumberOfAllEvents \t" + logParser.getNumberOfAllEvents(after, before2));
        System.out.println("getAllEvents \t" + logParser.getAllEvents(after, before2));
        System.out.println("getEventsForIP \t" + logParser.getEventsForIP("146.34.15.5", after, before2));
        System.out.println("getEventsForUser \t" + logParser.getEventsForUser("Eduard Petrovich Morozko", after, before2));
        System.out.println("getFailedEvents \t" + logParser.getFailedEvents(after, before2));
        System.out.println("getErrorEvents \t" + logParser.getErrorEvents(after, before2));
        System.out.println("getNumberOfAttemptToSolveTask \t" + logParser.getNumberOfAttemptToSolveTask(18, null, null));
        System.out.println("getNumberOfSuccessfulAttemptToSolveTask \t" + logParser.getNumberOfSuccessfulAttemptToSolveTask(15, null, null));
        System.out.println("getAllSolvedTasksAndTheirNumber \t" + logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println("getAllDoneTasksAndTheirNumber \t" + logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println();
        System.out.println("execute get ip \t" + logParser.execute("get ip"));
        System.out.println("execute get user \t" + logParser.execute("get user"));
        System.out.println("execute get date \t" + logParser.execute("get date"));
        System.out.println("execute get event \t" + logParser.execute("get event"));
        System.out.println("execute get status \t" + logParser.execute("get status"));
        System.out.println();
        System.out.println("execute get event for date = \"3.1.2014 3:45:23\" \t" + logParser.execute("get event for date = \"3.1.2014 3:45:23\""));
        System.out.println("execute get event for date = \"03.01.2014 3:45:23\" \t" + logParser.execute("get event for date = \"03.01.2014 3:45:23\""));
        System.out.println("execute get event for date = \" \t" + logParser.execute("get event for date = \""));
        System.out.println("execute get date for date = \"29.2.2028 05:4:7\" \t" + logParser.execute("get date for date = \"29.2.2028 05:4:7\""));
        System.out.println("execute get user for date = \"29.02.2028 05:4:07\" \t" + logParser.execute("get user for date = \"29.02.2028 05:4:07\""));
        /*[LOGIN]
            [LOGIN]
            []
            [Tue Feb 29 05:04:07 EET 2028]
            [Amigo]*/

        System.out.println("execute get user for =date = \"29.02.2028 05:4:07\" \t" + logParser.execute("get user for =date = \"29.02.2028 05:4:07\""));
        System.out.println("execute get =user for date = \"29.02.2028 05:4:07\" \t" + logParser.execute("get =user for date = \"29.02.2028 05:4:07\""));
        System.out.println("execute get date for date = \"25.2.2028 05:4:7\" \t" + logParser.execute("get date for date = \"25.2.2028 05:4:7\""));

        /*[Amigo, Vasya Pupkin, Eduard Petrovich Morozko]
            null
            []*/

        System.out.println();
        System.out.println("execute get ip for ip = \"127.0.0.1\" \t" + logParser.execute("get ip for ip = \"127.0.0.1\""));
        System.out.println("execute get ip for USER = \"Eduard Petrovich Morozko\"" + logParser.execute("get ip for user = \"Eduard Petrovich Morozko\""));
        System.out.println("execute get ip for event = \"SOLVE_TASK\"" + logParser.execute("get ip for event = \"SOLVE_TASK\""));
        System.out.println("execute get ip for status = \"FAILED\"" + logParser.execute("get ip for status = \"FAILED\""));
        System.out.println("execute get ip for date = \"30.08.2012 16:08:40\"" + logParser.execute("get ip for date = \"30.08.2012 16:08:40\""));
        System.out.println("execute get user for ip = \"127.0.0.1\"" + logParser.execute("get user for ip = \"127.0.0.1\""));
        System.out.println("execute get user for user = \"Amigo\"" + logParser.execute("get user for user = \"Amigo\""));
    }
}