package com.javarush.task.task39.task3913;

import java.util.Date;

public class OneLog {
    private String ip;
    private String name;
    private Date date;
    private Event event;
    private Status status;

    public OneLog(String ip, String name, Date date, Event event, Status status) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
