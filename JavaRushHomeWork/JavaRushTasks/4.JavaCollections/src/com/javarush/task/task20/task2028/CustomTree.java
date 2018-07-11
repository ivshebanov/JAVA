package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    private static Entry<String> root;

    static {
        root = new Entry<>("0");
    }
    public CustomTree() {

    }

    public static void printTree() {
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry node = queue.poll();
            System.out.print(" (" + node.elementName + ") ");
            if (node.leftChild != null) queue.add(node.leftChild);
            if (node.rightChild != null) queue.add(node.rightChild);
        }
    }

    public String getParent(String name) {
        if (name.isEmpty()) return "not found";
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> el = queue.poll();
            if (el.parent != null) {
                if (el.elementName.equals(name)) return el.parent.elementName;
            }
            if (el.leftChild != null) queue.add(el.leftChild);
            if (el.rightChild != null) queue.add(el.rightChild);
        }
        return "not found";
    }

    public boolean remove(Object o) {
        if (o == null) throw new UnsupportedOperationException();
        String name;
        try {
            name = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> el;
        while (!queue.isEmpty()) {
            el = queue.poll();
            if (!el.availableToAddLeftChildren) {
                if (el.leftChild.elementName.equals(name)) {
                    el.leftChild = null;
                    el.checkChildren();
                    return true;
                }else queue.add(el.leftChild);
            }
            if (!el.availableToAddRightChildren) {
                if (el.rightChild.elementName.equals(name)) {
                    el.rightChild = null;
                    el.checkChildren();
                    return true;
                }else queue.add(el.rightChild);
            }
        }
        return false;
    }

    @Override
    public boolean add(String elementName) {
        if (elementName.isEmpty()) return false;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> el = queue.poll();
            if (el.isAvailableToAddChildren()) {
                if (el.availableToAddLeftChildren) {
                    el.leftChild = new Entry<>(elementName);
                    el.leftChild.parent = el;
                    el.checkChildren();
                    return true;
                } else if (el.availableToAddRightChildren) {
                    el.rightChild = new Entry<>(elementName);
                    el.rightChild.parent = el;
                    el.checkChildren();
                    return true;
                }
            } else {
                if (el.leftChild != null) queue.add(el.leftChild);
                if (el.rightChild != null) queue.add(el.rightChild);
            }
        }
        return false;
    }

    @Override
    public int size() {
        if (root == null) return 0;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Entry<String> el = queue.poll();
            if (el.leftChild != null) queue.add(el.leftChild);
            if (el.rightChild != null) queue.add(el.rightChild);
        }
        return count - 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "elementName='" + elementName + '\'' +
                    ", lineNumber=" + lineNumber +
                    ", availableToAddLeftChildren=" + availableToAddLeftChildren +
                    ", availableToAddRightChildren=" + availableToAddRightChildren +
                    ", parent=" + parent +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
