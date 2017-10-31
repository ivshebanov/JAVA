package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private long amountPerOneDisplaying;//стоимость одного показа рекламного объявления
    private Object content;//видео.
    private String name;
    private long initialAmount;//начальная сумма, стоимость рекламы в копейках.
    private int hits;//количество оплаченных показов.
    private int duration;//продолжительность в секундах.

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

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public int getHits() {
        return hits;
    }
}
