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
import java.util.HashSet;
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
        int status = logParser.getNumberOfUniqueIPs(after, before);
        System.out.println(status);
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        if (logDir == null || !logDir.toFile().isFile()) {
            return 0;
        }

        List<OneLog> list = getLogsForPeriod(after, before);
        Set<String> resultNumberOfUniqueIPs = getSetOfUniqueIPs(list);

        return resultNumberOfUniqueIPs.size();
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

    private Set<String> getSetOfUniqueIPs(List<OneLog> logs) {
        if (logs == null || logs.size() == 0) {
            return null;
        }
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : logs) {
            resultSet.add(log.getIp());
        }
        return resultSet;
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
        if (after == null) {
            after = new Date(0);
        }

        if (before == null) {
            before = new Date();
        }

        return current.after(after) && current.before(before);
    }

    private OneLog getOneLog(String log) {
        if (log == null || log.isEmpty()) {
            return null;
        }

        log = log.replace('\t', ' ');
        if (log.contains("\n")) {
            log = log.substring(0, log.length() - 1);
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
        String ip = getIpLog(log);
        String date = getDateStringLog(log);
        String[] element = log.split(" ");

        String nameResult = "";
        for (String el : element) {
            if (el.equals(ip)) {
                continue;
            }
            if (el.equals(date)) {
                break;
            }
            nameResult = nameResult + el + " ";
        }
        nameResult = nameResult.substring(0, nameResult.length() - 1);
        return nameResult;
    }

    private Date getDateLog(String log) {
        String date = getDateStringLog(log);
        String time = getTimeStringLog(log);
        return getDateByDateAndTime(date, time);
    }

    private String getDateStringLog(String log) {
        String pattern = "(\\d{1})+.(\\d{1})+.\\d{4}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(log);
        String date = "";
        while (m.find()) {
            date = m.start() + m.group();
        }
        date = date.substring(2);
        return date;
    }

    private String getTimeStringLog(String log) {
        String pattern1 = "(\\d{1})+:(\\d{1})+:(\\d{1})+";
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(log);
        String time = "";
        while (m1.find()) {
            time = m1.start() + m1.group();
        }
        time = time.substring(2);
        return time;
    }

    private Event getEventLog(String log) {
        String[] elementLog = log.split(" ");
        Event[] events = Event.values();

        for (Event element : events) {
            for (String str : elementLog) {
                if (element.name().equals(str)) {
                    return element;
                }
            }
        }
        return null;
    }

    private String getParameter(String log) {
        Event event = getEventLog(log);
        if (event == null) {
            return null;
        }

        String resultStr = "";
        if (event.equals(Event.SOLVE_TASK) || event.equals(Event.DONE_TASK)) {
            String[] elements = log.split(" ");
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(Event.SOLVE_TASK.name()) || elements[i].equals(Event.DONE_TASK.name())) {
                    resultStr = elements[i + 1];
                    break;
                }
            }
        }
        return resultStr;
    }

    private Status getStatusLog(String log) {
        String[] element = log.split(" ");
        String stringStatus = element[element.length - 1];
        return Status.valueOf(stringStatus);
    }
}