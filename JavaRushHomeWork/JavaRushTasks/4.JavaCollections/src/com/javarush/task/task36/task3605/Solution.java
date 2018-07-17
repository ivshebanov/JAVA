package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
D:\hotj\JAVA\JavaRushHomeWork\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task36\task3605\file.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            // чтение посимвольно
            TreeSet<String> set = new TreeSet<>();
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isLetter(c)) {
                    String letter = Character.toString((char) c).toLowerCase();
                    set.add(letter);
                }
            }
            Iterator iterator = set.iterator();
            for (int i = 0; i < 5 ; i ++){
                if (iterator.hasNext()) System.out.print(iterator.next());
                else return;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
