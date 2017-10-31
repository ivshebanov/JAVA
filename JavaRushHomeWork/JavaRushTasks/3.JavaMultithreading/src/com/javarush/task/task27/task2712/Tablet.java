package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.*;
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
            ConsoleHelper.writeMessage(orderResult.toString());
            if (!orderResult.isEmpty()){
                setChanged();
                notifyObservers(orderResult);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "orderResult.isEmpty() == true");
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
