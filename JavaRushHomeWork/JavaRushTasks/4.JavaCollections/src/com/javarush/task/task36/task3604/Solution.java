package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        System.out.println(rbt.isEmpty());
        int[] arr = {4, 6, 2, 3, 1, 5, 9, 8, 7};
        for (int anArr : arr) {
            rbt.insert(anArr);
            rbt.printTree();
            System.out.println();
        }
        System.out.println(rbt.isEmpty());

        rbt.clear();
        System.out.println(rbt.isEmpty());
    }
}
