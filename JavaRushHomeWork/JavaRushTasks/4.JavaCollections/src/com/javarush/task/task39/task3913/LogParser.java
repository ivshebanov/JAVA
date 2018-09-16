package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.DateQuery;
import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

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

public class LogParser implements IPQuery, UserQuery, DateQuery {

    private static final String PATTERN_GET_DATE = "(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1?[012])[.]\\d\\d\\d\\d\\d?";
    private static final String PATTERN_GET_TIME = "(\\d{1})+:(\\d{1})+:(\\d{1})+";
    private static final String PATTERN_GET_IP = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        return getSetOfUniqueIPs(listLogsForPeriod);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        if (user == null || user.isEmpty()) {
            return emptySet();
        }
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        List<OneLog> listLogsForUser = new ArrayList<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getName().equals(user)) {
                listLogsForUser.add(log);
            }
        }
        return getSetOfUniqueIPs(listLogsForUser);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        if (event == null) {
            return emptySet();
        }
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        List<OneLog> listLogsForEvent = new ArrayList<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(event)) {
                listLogsForEvent.add(log);
            }
        }
        return getSetOfUniqueIPs(listLogsForEvent);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        if (status == null) {
            return emptySet();
        }
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        List<OneLog> listLogsForStatus = new ArrayList<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getStatus().equals(status)) {
                listLogsForStatus.add(log);
            }
        }
        return getSetOfUniqueIPs(listLogsForStatus);
    }

    @Override
    public Set<String> getAllUsers() {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, null, null);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            resultSet.add(log.getName());
        }
        return resultSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            resultSet.add(log.getName());
        }
        return resultSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<Event> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getName().equals(user)) {
                resultSet.add(log.getEvent());
            }
        }
        return resultSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getIp().equals(ip)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.LOGIN)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.DOWNLOAD_PLUGIN)
                    && log.getStatus().equals(Status.OK)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.WRITE_MESSAGE)
                    && log.getStatus().equals(Status.OK)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.SOLVE_TASK)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.SOLVE_TASK)
                    && log.getParameter() == task) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.DONE_TASK)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        if (task == 0) {
            return emptySet();
        }
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : listLogsForPeriod) {
            if (log.getEvent().equals(Event.DONE_TASK)
                    && log.getParameter() == task) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        if (user == null || user.isEmpty() || event == null) {
            return emptySet();
        }
        Set<Date> resultSet = new HashSet<>();
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        for (OneLog log : listLogsForPeriod) {
            if (log.getName().equals(user)
                    && log.getEvent().equals(event)) {
                resultSet.add(log.getDate());
            }
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        for (OneLog log : listLogsForPeriod) {
            if (log.getStatus().equals(Status.FAILED)) {
                resultSet.add(log.getDate());
            }
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        List<OneLog> listAllLogs = getAllLogs();
        List<OneLog> listLogsForPeriod = getLogsForPeriod(listAllLogs, after, before);
        for (OneLog log : listLogsForPeriod) {
            if (log.getStatus().equals(Status.ERROR)) {
                resultSet.add(log.getDate());
            }
        }
        return resultSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return null;
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

    private List<OneLog> getAllLogs() {
        if (logDir == null) {
            return emptyList();
        }
        File file = new File(logDir.toString());
        List<String> allLogsString = new ArrayList<>();
        if (file.isFile() && checkFileLog(file)) {
            allLogsString.addAll(loadListOfLogsFromFile(file));
        }
        if (file.isDirectory()) {
            getAllLogsString(allLogsString, file);
        }
        if (allLogsString.size() == 0) {
            return emptyList();
        }
        List<OneLog> resultLog = new ArrayList<>();
        for (String log : allLogsString) {
            OneLog oneLog = getOneLog(log);
            resultLog.add(oneLog);
        }
        return resultLog;
    }

    private List<OneLog> getLogsForPeriod(List<OneLog> logs, Date after, Date before) {
        List<OneLog> resultLog = new ArrayList<>();
        for (OneLog log : logs) {
            if (checkData(after, before, log.getDate())) {
                resultLog.add(log);
            }
        }
        return resultLog;
    }

    private List<String> getAllLogsString(List<String> logs, File file) {
        File[] folderEntries = file.listFiles();

        if (folderEntries == null || folderEntries.length == 0) {
            return emptyList();
        }

        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                getAllLogsString(logs, entry);
            }

            if (entry.isFile() && checkFileLog(entry)) {
                logs.addAll(loadListOfLogsFromFile(entry));
            }
        }

        return logs;
    }

    private List<String> loadListOfLogsFromFile(File file) {
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
        return (after == null || current.after(after) || current.equals(after)) &&
                (before == null || current.before(before) || current.equals(before));
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
        int parameter = getParameter(log);
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

    private int getParameter(String log) {
        Event event = getEventLog(log);
        if (event == null) {
            return 0;
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
        int result = 0;
        if (resultStr != null && !resultStr.isEmpty()) {
            try {
                result = Integer.parseInt(resultStr);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private Status getStatusLog(String log) {
        String[] element = log.split(" ");
        String stringStatus = element[element.length - 1];
        return Status.valueOf(stringStatus);
    }
}