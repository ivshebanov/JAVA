package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

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
        if (map.containsKey(key)) {
            LinkedList<V> list = (LinkedList<V>) map.get(key);
            if (list.size() < repeatCount) {
                list.addLast(value);
                map.put(key, list);
            } else if (list.size() == repeatCount) {
                V el = list.getLast();
                list.removeFirst();
                list.addLast(value);
                map.put(key, list);
                return el;
            }
        } else {
            LinkedList<V> list = new LinkedList<>();
            list.addLast(value);
            map.put(key, list);
            return null;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        K keyy = (K) key;
        if (!map.containsKey(keyy)) {
            return null;
        } else {
            LinkedList<V> list = (LinkedList<V>) map.get(key);
            if (list.isEmpty()) {
                map.remove(keyy);
                return null;
            } else {
                V el = list.getFirst();
                list.removeFirst();
                map.put(keyy, list);
                return el;
            }
        }
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        HashSet<K> resultSet = new HashSet<>();
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
        K keyy = (K) key;
        return map.containsKey(keyy);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        V v = (V) value;
        for (Entry<K, List<V>> entry : map.entrySet()) {
            List<V> list = entry.getValue();
            for (V el : list) {
                if (el == v) {
                    return true;
                }
            }
        }
        return false;
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