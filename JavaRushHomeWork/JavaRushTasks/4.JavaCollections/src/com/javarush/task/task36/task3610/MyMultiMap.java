package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int resultSize = 0;
        for (Entry<K, List<V>> entry : map.entrySet()) {
            resultSize = resultSize + entry.getValue().size();
        }
        return resultSize;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> list = map.get(key);
        V resultElement = null;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            resultElement = list.get(list.size() - 1);
            if (list.size() == repeatCount) {
                list.remove(0);
            }
        }
        list.add(value);
        map.put(key, list);
        return resultElement;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> list = map.get(key);
        if (list == null) {
            return null;
        }
        V resultElement = list.get(0);
        list.remove(0);
        if (list.isEmpty()) {
            map.remove(key);
        }
        return resultElement;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        Set<K> resultSet = new HashSet<>();
        for (Entry<K, List<V>> entry : map.entrySet()) {
            resultSet.add(entry.getKey());
        }
        return resultSet;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        Collection<V> resultCollection = new ArrayList<>();
        for (Entry<K, List<V>> entry : map.entrySet()) {
            resultCollection.addAll(entry.getValue());
        }
        return resultCollection;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}