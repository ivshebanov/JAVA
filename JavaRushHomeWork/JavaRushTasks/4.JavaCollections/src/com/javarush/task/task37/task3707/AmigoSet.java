package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        this.map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int) (collection.size()/.75f) + 1, 16));
        addAll(collection);
    }

    @Override
    public boolean add(E e){
        return this.map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        Set<E> set = map.keySet();
        return set.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return super.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public boolean containsAll(Collection c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return super.addAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
