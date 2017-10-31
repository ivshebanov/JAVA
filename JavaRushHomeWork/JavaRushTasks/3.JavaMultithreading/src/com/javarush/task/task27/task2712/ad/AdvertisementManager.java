package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> availableVideos = storage.list();
        if (availableVideos.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> videoToBeShown = new ArrayList<>();
        for (Advertisement ad : availableVideos) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0) {
                videoToBeShown.add(ad);
            }
        }

        videoToBeShown = getVideos(videoToBeShown, 0);
        if (videoToBeShown.isEmpty()) {
            throw new NoVideoAvailableException();
        }


        Collections.sort(videoToBeShown, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result == 0)
                    result = Long.compare(o1.getAmountPerOneDisplaying() / o1.getDuration(),
                            o2.getAmountPerOneDisplaying() / o2.getDuration());
                return result;
            }
        });
        Collections.reverse(videoToBeShown);
        for (Advertisement ad : videoToBeShown) {
            ConsoleHelper.writeMessage(String.format("%s  is displaying... %d, %d",
                    ad.getName(),
                    ad.getAmountPerOneDisplaying(),
                    ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ad.revalidate();
        }

    }

    public List<Advertisement> getVideos(List<Advertisement> inList, int start) {
        List<Advertisement> storageList = storage.list();
        List<Advertisement> tmp;
        List<Advertisement> result = new ArrayList<>();

        int timeLeft = timeSeconds - sumOfTime(inList);

        Advertisement ad;

        for (int i = start; i < storageList.size(); i++) { // проходим по сторейдж массиву
            ad = storageList.get(i);
            if (!inList.contains(ad) && ad.getHits() > 0 && (ad.getDuration() <= timeLeft)) {
                inList.add(ad);
                result = checkWhoBetter(inList, getVideos(inList, i));
            }
        }
        return result;
    }

    // выводит сумму прибыли за показ листа
    public int sumOfListMoney(List<Advertisement> list) {
        int sum = 0;
        for (Advertisement ad : list) {
            sum += ad.getAmountPerOneDisplaying();
        }
        return sum;
    }

    // возвращает суммарную длительность роликов в листе
    public int sumOfTime(List<Advertisement> list) {
        int summ = 0;
        for (Advertisement ad : list) {
            summ += ad.getDuration();
        }
        return summ;
    }

    //сравнивает два листа по требованиям
    public List<Advertisement> checkWhoBetter(List<Advertisement> check, List<Advertisement> tmp) {
        List<Advertisement> result = new ArrayList<>();
        if (sumOfListMoney(check) > sumOfListMoney(tmp)) result = check;
        if (sumOfListMoney(check) < sumOfListMoney(tmp)) result = tmp;
        if (sumOfListMoney(check) == sumOfListMoney(tmp)) {
            if (sumOfTime(check) > sumOfTime(tmp)) result = check;
            if (sumOfTime(check) < sumOfTime(tmp)) result = tmp;
            if (sumOfTime(check) == sumOfTime(tmp)) {
                if (check.size() > tmp.size()) result = check;
                else result = tmp;
            }
        }
        return result;
    }
}
