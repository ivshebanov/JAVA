package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.emptyList;

public class LogParser implements IPQuery {

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    public static void main(String[] args) {
        String path = "/Users/iliashebanov/Documents/Java/JavaRush/JavaRushHomeWork/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/example.log";
        Path path1 = Paths.get(path);
        LogParser logParser = new LogParser(path1);
        String s = "146.34.15.5\tEduard Petrovich Morozko\t13.09.2013 5:04:50\tDOWNLOAD_PLUGIN\tOK\n";
        Event status = logParser.getEventLog(s);
        System.out.println(status.name());
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        if (logDir == null || !logDir.toFile().isFile()) {
            return 0;
        }

        List<OneLog> list = getLogsForPeriod(after, before);

        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }

    private List<OneLog> getLogsForPeriod(Date after, Date before) {

        List<String> allLogsString = null;
        try {
            allLogsString = Files.readAllLines(logDir, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (allLogsString == null || allLogsString.size() == 0) {
            return emptyList();
        }

        List<OneLog> allOneLogs = new ArrayList<>();
        for (String log : allLogsString) {
            allOneLogs.add(getOneLog(log));
        }

        List<OneLog> resultLog = new ArrayList<>();
        for (OneLog log : allOneLogs) {
            if (checkData(after, before, log.getDate())) {
                resultLog.add(log);
            }
        }

        return resultLog;
    }

    private Date getDateByDateAndTime(String date, String time) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date resultDate = null;
        try {
            resultDate = formatForDateNow.parse(date + " " + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    private boolean checkData(Date after, Date before, Date current) {
        Date afterNew = after;
        Date beforeNew = before;

        if (after == null) {
            afterNew = new Date(0);
        }

        if (before == null) {
            beforeNew = new Date();
        }

        return (afterNew.getTime() < current.getTime()) && (beforeNew.getTime() > current.getTime());
    }

    private OneLog getOneLog(String log) {
        if (log == null || log.isEmpty()) {
            return null;
        }

        String ip = getIpLog(log);
        String name = getNameLog(log);
        Date date = getDateLog(log);
        Event event = getEventLog(log);
        String parameter = getParameter(log);
        Status status = getStatusLog(log);

        return new OneLog(ip, name, date, event, parameter, status);
    }

    private String getIpLog(String log) {
        log = log.replace('\t', ' ');
        log = log.replace(log.substring(log.length() - 1), "");

        String pattern = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(log);

        String ip = "";
        while (m.find()) {
            ip = m.start() + m.group();
        }
        ip = ip.substring(1);
        return ip;
    }

    private String getNameLog(String log) {
        return null;
    }

    private Date getDateLog(String log) {
        log = log.replace('\t', ' ');
        log = log.replace(log.substring(log.length() - 1), "");

        String pattern = "(\\d{1})+.(\\d{1})+.\\d{4}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(log);

        String date = "";
        while (m.find()) {
            date = m.start() + m.group();
        }

        String pattern1 = "(\\d{1})+:(\\d{1})+:(\\d{1})+";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(log);

        String time = "";
        while (m1.find()) {
            time = m1.start() + m1.group();
        }

        date = date.substring(2);
        time = time.substring(2);

        return getDateByDateAndTime(date, time);
    }

    private Event getEventLog(String log) {
        log = log.replace('\t', ' ');
        log = log.replace(log.substring(log.length() - 1), "");
        String[] elementLog = log.split(" ");
        Event[] events = Event.values();

        for (Event element : events){
            for (String str : elementLog){
                if (element.name().equals(str)){
                    return element;
                }
            }
        }
        return null;
    }

    private String getParameter(String log) {
        return null;
    }

    private Status getStatusLog(String log) {
        log = log.replace('\t', ' ');
        log = log.replace(log.substring(log.length() - 1), "");
        String[] element = log.split(" ");
        String stringStatus = element[element.length - 1];
        return Status.valueOf(stringStatus);
    }
}