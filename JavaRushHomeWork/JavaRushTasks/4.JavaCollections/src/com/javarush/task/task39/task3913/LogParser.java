package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;

public class LogParser implements IPQuery {

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
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
        String[] element = log.split(" ");

        String ip = getIpLog(element);
        String name = getNameLog(element);
        Date date = getDateLog(element);
        Event event = getEventLog(element);
        String parameter = getParameter(element);
        Status status = getStatusLog(element);

        return new OneLog(ip, name, date, event, parameter, status);
    }

    private String getIpLog(String[] element) {
        return null;
    }

    private String getNameLog(String[] log) {
        return null;
    }

    private Date getDateLog(String[] log) {
        return null;
    }

    private Event getEventLog(String[] log) {
        return null;
    }

    private String getParameter(String[] element) {
        return null;
    }

    private Status getStatusLog(String[] element) {
        return null;
    }
}