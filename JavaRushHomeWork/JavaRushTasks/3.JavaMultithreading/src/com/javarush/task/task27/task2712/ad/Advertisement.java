package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private long amountPerOneDisplaying;
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
