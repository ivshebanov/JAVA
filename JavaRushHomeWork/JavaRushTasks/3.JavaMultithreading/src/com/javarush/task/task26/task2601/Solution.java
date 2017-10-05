package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] integers = new Integer[]{13, 8, 15, 5, 17, 1};
//        Integer[] integers1 = sort(integers);
//        System.out.println(Arrays.toString(integers1));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        int listSize = list.size();
        Integer median = listSize % 2 != 0
                ? list.get(listSize / 2)
                : (list.get(listSize / 2) + list.get((listSize / 2) - 1)) / 2;
        Comparator<Integer> compare = (o1, o2) -> Math.abs(o1 - median) - Math.abs(o2 - median);
        list.sort(compare);
        Integer[] integers = new Integer[listSize];
        list.toArray(integers);
        return integers;
    }
}
