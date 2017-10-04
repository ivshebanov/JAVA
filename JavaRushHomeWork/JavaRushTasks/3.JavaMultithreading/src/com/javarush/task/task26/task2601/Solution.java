package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{13, 8, 15, 5, 17};
        Integer[] integers1 = sort(integers);
        System.out.println(Arrays.toString(integers1));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list);
        Integer median;
        //правильно найти медиану
//        if (list.size() % 2 == 0) {
//            median = list.get((list.size() / 2) - 1);
//        } else {
        median = list.get(list.size() / 2);
//        }
        System.out.println(median);
        assert median != null;
        List<Integer> list1 = list.subList(list.indexOf(median), list.size());
        System.out.println(list1);
        List<Integer> list2 = list.subList(0, list.indexOf(median));
        System.out.println(list2);
        Collections.reverse(list2);
        ArrayList<Integer> result = new ArrayList<>(list1);
        result.addAll(list2);
        Integer[] integers = new Integer[result.size()];
        result.toArray(new Integer[result.size()]);
        return integers;
    }
}
