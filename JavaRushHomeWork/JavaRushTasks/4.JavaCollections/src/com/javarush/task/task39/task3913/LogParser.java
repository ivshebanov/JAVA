package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
import static java.util.Collections.emptySet;

public class LogParser implements IPQuery {

    private static final String PATTERN_GET_DATE = "(\\d{1})+.(\\d{1})+.\\d{4}";
    private static final String PATTERN_GET_TIME = "(\\d{1})+:(\\d{1})+:(\\d{1})+";
    private static final String PATTERN_GET_IP = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        List<OneLog> list = getLogsForPeriod(after, before);
        Set<String> resultNumberOfUniqueIPs = getSetOfUniqueIPs(list);
        return resultNumberOfUniqueIPs.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<OneLog> list = getLogsForPeriod(after, before);
        return getSetOfUniqueIPs(list);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        if (user == null || user.isEmpty()) {
            return emptySet();
        }
        List<OneLog> listAllLogsForPeriod = getLogsForPeriod(after, before);
        List<OneLog> listLogsForUser = getLogForUser(listAllLogsForPeriod, user);
        return getSetOfUniqueIPs(listLogsForUser);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        if (event == null) {
            return emptySet();
        }
        List<OneLog> listAllLogsForPeriod = getLogsForPeriod(after, before);
        List<OneLog> listLogsForEvent = getLogForEvent(listAllLogsForPeriod, event);
        return getSetOfUniqueIPs(listLogsForEvent);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        if (status == null) {
            return emptySet();
        }
        List<OneLog> listAllLogsForPeriod = getLogsForPeriod(after, before);
        List<OneLog> listLogsForStatus = getLogForStatus(listAllLogsForPeriod, status);
        return getSetOfUniqueIPs(listLogsForStatus);
    }

    private List<OneLog> getLogForStatus(List<OneLog> logs, Status status) {
        if (logs == null || logs.size() == 0 || status == null) {
            return emptyList();
        }
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logs) {
            if (log.getStatus().equals(status)) {
                resultLogs.add(log);
            }
        }
        return resultLogs;
    }

    private List<OneLog> getLogForEvent(List<OneLog> logs, Event event) {
        if (logs == null || logs.size() == 0 || event == null) {
            return emptyList();
        }
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logs) {
            if (log.getEvent().equals(event)) {
                resultLogs.add(log);
            }
        }
        return resultLogs;
    }

    private List<OneLog> getLogForUser(List<OneLog> logs, String user) {
        if (logs == null || logs.size() == 0 || user == null || user.isEmpty()) {
            return emptyList();
        }
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logs) {
            if (log.getName().equals(user)) {
                resultLogs.add(log);
            }
        }
        return resultLogs;
    }

    private Set<String> getSetOfUniqueIPs(List<OneLog> logs) {
        if (logs == null || logs.size() == 0) {
            return emptySet();
        }
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : logs) {
            resultSet.add(log.getIp());
        }
        return resultSet;
    }

    private List<OneLog> getLogsForPeriod(Date after, Date before) {
        if (logDir == null) {
            return emptyList();
        }

        List<String> allLogsString = new ArrayList<>();
        File file = new File(logDir.toString());

        if (file.isFile() && checkFileLog(file)) {
            allLogsString.addAll(readFileLog(file));
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return emptyList();
            }
            for (File ff : files) {
                if (ff.isFile() && checkFileLog(ff)) {
                    allLogsString.addAll(readFileLog(ff));
                }
            }
        }

        if (allLogsString.size() == 0) {
            return emptyList();
        }

        List<OneLog> resultLog = new ArrayList<>();
        for (String log : allLogsString) {
            OneLog oneLog = getOneLog(log);
            if (oneLog == null) {
                return emptyList();
            }
            if (checkData(after, before, oneLog.getDate())) {
                resultLog.add(oneLog);
            }
        }

        return resultLog;
    }

    private List<String> readFileLog(File file) {
        if (!file.exists() && !file.isFile()) {
            return emptyList();
        }
        List<String> allLogsString = null;
        try {
            allLogsString = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLogsString;
    }

    private boolean checkFileLog(File file) {
        return file.toPath().toString().toLowerCase().endsWith(".log");
    }

    private Date getDateByDateAndTime(String date, String time) {
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("d.M.y H:m:s");
        Date resultDate = null;
        try {
            resultDate = formatForDateNow.parse(date + " " + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    private boolean checkData(Date after, Date before, Date current) {
        boolean fits = before == null || current.before(before) || current.equals(before);
        return fits && (after == null || current.after(after) || current.equals(after));
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
        String ip = patternPars(log, PATTERN_GET_IP);
        ip = ip.substring(1);
        return ip;
    }

    private String getNameLog(String log) {
        String ip = getIpLog(log);
        String date = getDateStringLog(log);
        String[] element = log.split(" ");

        StringBuilder nameResult = new StringBuilder();
        for (String el : element) {
            if (el.equals(ip)) {
                continue;
            }
            if (el.equals(date)) {
                break;
            }
            nameResult.append(el).append(" ");
        }
        nameResult = new StringBuilder(nameResult.substring(0, nameResult.length() - 1));
        return nameResult.toString();
    }

    private Date getDateLog(String log) {
        String date = getDateStringLog(log);
        String time = getTimeStringLog(log);
        return getDateByDateAndTime(date, time);
    }

    private String getDateStringLog(String log) {
        String date = patternPars(log, PATTERN_GET_DATE);
        date = date.substring(2);
        return date;
    }

    private String getTimeStringLog(String log) {
        String time = patternPars(log, PATTERN_GET_TIME);
        time = time.substring(2);
        return time;
    }

    private String patternPars(String log, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(log);
        String data = "";
        while (m.find()) {
            data = m.start() + m.group();
        }
        return data;
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