package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        sSort();
    }
    private static void sSort(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner;
        try {
            String mName = reader.readLine();
            scanner = new Scanner(new File(mName));
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            while (scanner.hasNext()){
                list1.add(new Integer(scanner.next()));
            }
            Collections.sort(list1, new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return o1.compareTo(o2);
                }
            });
            for(Integer s: list1){
                if (s % 2 == 0) System.out.println(s);
            }

        }catch (IOException e){
            System.out.println("Такого файла нет.");
        }
    }
}