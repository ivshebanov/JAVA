package com.javarush.task.task26.task2603;

import java.util.*;

/*
Убежденному убеждать других не трудно
*/
class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {

        Comparator[] comparable = new Comparator[2];
        comparable[0] = new B();
        comparable[1] = new A();

        CustomizedComparator customizedComparator = new CustomizedComparator(comparable);

        Set<Person> personTreeSet = new TreeSet<Person>(customizedComparator);
        personTreeSet.add(new Person(12, "q"));
        personTreeSet.add(new Person(12, "q"));
        personTreeSet.add(new Person(29, "c"));
        personTreeSet.add(new Person(2, "z"));
        personTreeSet.add(new Person(4, "g"));
        personTreeSet.add(new Person(29, "b"));
        personTreeSet.add(new Person(29, "a"));

        for (Person p : personTreeSet) {
            System.out.println(p);
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        //compiler didn`t accept with []
        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            result = comparators[0].compare(o1, o2);
            if (result == 0) {
                result = comparators[1].compare(o1, o2);
            }
            return result;
        }
    }

    public static class A<T> implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class B<T> implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}
