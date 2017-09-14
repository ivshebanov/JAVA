package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {
        if (n == null){
            System.out.println("1");
            return false;
        }
        if (!this.first.equals(n.first)){
            System.out.println("2");
            return false;
        }
        if (!this.last.equals(n.last)){
            System.out.println("3");
            return false;
        }
        return true;
    }

    public int hashCode() {
//        System.out.println("0");
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + first.hashCode();
//        result = prime * result + last.hashCode();
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
//        Solution s = new Solution("Donald", "Duck");
//        Solution d = new Solution("Donald", "Duck");
//        System.out.println(s.equals(d));
    }
}
