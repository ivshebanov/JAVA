package com.javarush.task.task39.task3913;

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

public class LogParser implements IPQuery, UserQuery {

    private static final String PATTERN_GET_DATE = "(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1?[012])[.]\\d\\d\\d\\d\\d?";
    private static final String PATTERN_GET_TIME = "(\\d{1})+:(\\d{1})+:(\\d{1})+";
    private static final String PATTERN_GET_IP = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
    private static final String PATTERN_GET_NAME = "([A-Z][a-z]+) ?([A-Z][a-z]+)? ?([A-Z][a-z]+)?";

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
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        return getSetOfUniqueIPs(logsForPeriodList);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        if (user == null || user.isEmpty()) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getName().equals(user)) {
                resultLogs.add(log);
            }
        }
        return getSetOfUniqueIPs(resultLogs);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        if (event == null) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(event)) {
                resultLogs.add(log);
            }
        }
        return getSetOfUniqueIPs(resultLogs);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        if (status == null) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        List<OneLog> resultLogs = new ArrayList<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getStatus().equals(status)) {
                resultLogs.add(log);
            }
        }
        return getSetOfUniqueIPs(resultLogs);
    }

    @Override
    public Set<String> getAllUsers() {
        List<OneLog> logsForPeriodList = getLogsForPeriod(null, null);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            resultSet.add(log.getName());
        }
        return resultSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            resultSet.add(log.getName());
        }
        return resultSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        if (user == null || user.isEmpty()) {
            return 0;
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        int resultCount = 0;
        for (OneLog log : logsForPeriodList) {
            if (log.getName().equals(user)) {
                resultCount++;
            }
        }
        return resultCount;
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        if (ip == null || ip.isEmpty()) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> resultSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getIp().equals(ip)) {
                resultSet.add(log.getName());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> loggedUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.LOGIN)
                    && log.getStatus().equals(Status.OK)) {
                loggedUsersSet.add(log.getName());
            }
        }
        return loggedUsersSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> downloadedPluginSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.DOWNLOAD_PLUGIN)
                    && log.getStatus().equals(Status.OK)) {
                downloadedPluginSet.add(log.getName());
            }
        }
        return downloadedPluginSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> wroteMessageUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.WRITE_MESSAGE)
                    && log.getStatus().equals(Status.OK)) {
                wroteMessageUsersSet.add(log.getName());
            }
        }
        return wroteMessageUsersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> solvedTaskUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.SOLVE_TASK)) {
                solvedTaskUsersSet.add(log.getName());
            }
        }
        return solvedTaskUsersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        if (task == 0) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> solvedTaskUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.SOLVE_TASK)
                    && log.getParameter() == task) {
                solvedTaskUsersSet.add(log.getName());
            }
        }
        return solvedTaskUsersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> doneTaskUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.DONE_TASK)) {
                doneTaskUsersSet.add(log.getName());
            }
        }
        return doneTaskUsersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        if (task == 0) {
            return emptySet();
        }
        List<OneLog> logsForPeriodList = getLogsForPeriod(after, before);
        Set<String> doneTaskUsersSet = new HashSet<>();
        for (OneLog log : logsForPeriodList) {
            if (log.getEvent().equals(Event.DONE_TASK)
                    && log.getParameter() == task) {
                doneTaskUsersSet.add(log.getName());
            }
        }
        return doneTaskUsersSet;
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
            if (checkData(after, before, oneLog.getDate())) {
                resultLog.add(oneLog);
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
        String name = patternPars(log, PATTERN_GET_NAME);
        name = name.substring(2);
        if (name.charAt(name.length() - 1) == ' ') {
            name = name.substring(0, name.length() - 1);
        }
        return name;
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