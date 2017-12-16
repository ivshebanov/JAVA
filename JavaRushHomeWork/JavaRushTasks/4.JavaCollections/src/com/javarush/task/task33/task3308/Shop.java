package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public int count;
    public double profit;
    public Goods goods;
    public String[] secretData = new String[]{};

    public Shop() {
    }

    private static class Goods {
        public List<String> names;

        public Goods() {
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "count=" + count +
                ", profit=" + profit +
                ", goods=" + goods +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }
}
