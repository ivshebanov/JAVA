package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order orderResult = null;
        try {
            orderResult = new Order(this);
            if (!orderResult.isEmpty()) {
                ConsoleHelper.writeMessage(orderResult.toString());
                AdvertisementManager advertisementManager =
                        new AdvertisementManager(orderResult.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
                setChanged();
                notifyObservers(orderResult);
            }
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + orderResult);
        }catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return orderResult;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
