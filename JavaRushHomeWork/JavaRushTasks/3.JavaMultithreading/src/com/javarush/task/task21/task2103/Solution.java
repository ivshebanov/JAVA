package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {
        System.out.println(calculate(true, true, true, false));
        System.out.println(calculate(true, false, true, false));
        System.out.println(calculate(false, false, true, false));
        System.out.println(calculate(false, false, false, false));
    }
}
