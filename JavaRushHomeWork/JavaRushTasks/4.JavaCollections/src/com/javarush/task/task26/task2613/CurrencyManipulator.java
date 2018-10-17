package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.javarush.task.task26.task2613.ConsoleHelper.THERE_ARE_NO_BANKNOTES_IN_THE_ATM;
import static java.util.Collections.reverse;
import static java.util.Collections.sort;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new LinkedHashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        Integer currentDenomination = denominations.get(denomination);
        if (currentDenomination == null) {
            denominations.put(denomination, count);
            return;
        }

        if (currentDenomination > 0) {
            denominations.put(denomination, currentDenomination + count);
        }
    }

    public int getTotalAmount() {
        int resultAmount = 0;
        for (Map.Entry<Integer, Integer> el : denominations.entrySet()) {
            int denomination = el.getKey();
            int amount = el.getValue();
            resultAmount = resultAmount + (denomination * amount);
        }
        return resultAmount;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        Map<Integer, Integer> temp = new LinkedHashMap<>(denominations);
        List<Integer> list = new ArrayList<>(temp.keySet());

        sort(list);
        reverse(list);

        Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException(THERE_ARE_NO_BANKNOTES_IN_THE_ATM);
        else {
            denominations.clear();
            denominations.putAll(temp);
        }
        return result;
    }
}
