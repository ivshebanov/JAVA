package com.javarush.task.task39.task3913;

import java.util.Date;

public class OneLog {
    private String ip;
    private String name;
    private Date date;
    private Event event;
    private String parameter;
    private Status status;

    public OneLog(String ip, String name, Date date, Event event, String parameter, Status status) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.parameter = parameter;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public String getParameter() {
        return parameter;
    }

    public Status getStatus() {
        return status;
    }
}
