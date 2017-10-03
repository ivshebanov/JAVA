package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    private final Solution solution1;
    private final Solution solution2;

    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4, Solution solution1, Solution solution2) {
        this.solution1 = solution1;
        this.solution2 = solution2;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (solution1) {
            return var1 + var2;
        }
    }

    public strictfp int getSumOfVar3AndVar4() {
        synchronized (solution2) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
