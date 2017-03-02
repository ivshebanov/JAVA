package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {

        int[][] arr = new int[10][10];

        for(int i = 0; i<10; i++){
            for (int j = 0; j<10; j++) {
                arr[i][j] = (i+1) * (j+1);
                System.out.print( arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}