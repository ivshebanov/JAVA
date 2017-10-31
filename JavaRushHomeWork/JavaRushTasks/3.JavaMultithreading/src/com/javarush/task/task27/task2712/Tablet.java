package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private List<Observer> observers;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number) {
        this.number = number;
        observers = new LinkedList<>();
    }

    public Order createOrder() {
        Order orderResult = null;
        try {
            orderResult = new Order(this);
            ConsoleHelper.writeMessage(orderResult.toString());
            setChanged();
            notifyObservers(orderResult);
        } catch (IOException e) {
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

    @Override
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers)
            observer.update(this, arg);
    }
}
