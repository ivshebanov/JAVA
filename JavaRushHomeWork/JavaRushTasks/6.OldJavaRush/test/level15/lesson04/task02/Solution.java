package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix(m, (short)n, (String)value);
    }
    public static void printMatrix(int m, short n, String value) {
        printMatrix((short) m, n, value);
    }
    public static void printMatrix(short m, short n, String value) {
        printMatrix(m, (float) n, value);
    }
    public static void printMatrix(short m, float n, String value) {
        printMatrix((long)m, n, value);
    }
    public static void printMatrix(long m, float n, String value) {
        printMatrix(m, (long)n, value);
    }
    public static void printMatrix(long m, long n, String value) {
        printMatrix((double) m, n, value);
    }
    public static void printMatrix(double m, long n, String value) {
        printMatrix(m, (double) n, value);
    }
    public static void printMatrix(double m, double n, String value) {
        printMatrix((int)m, n, value);
    }
    public static void printMatrix(int m, double n, String value) {}
}
