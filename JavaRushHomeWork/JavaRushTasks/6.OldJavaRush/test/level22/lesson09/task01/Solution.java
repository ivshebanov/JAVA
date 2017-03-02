package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)      {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){
            //D:\Hotj\Dropbox\JAVA\JavaRushHomeWork\JavaRushHomeWork\src\com\javarush\test\level22\lesson09\task01\file
            reader.close();

            ArrayList<String> dataline = new ArrayList<String>();
            while(fileReader.ready()){
                dataline.addAll(Arrays.asList((fileReader.readLine().split(" "))));
            }
            fileReader.close();

//            for ( int i = 0; i < dataline.size() - 1; i++){
//
//                if (dataline.get(i) == null || dataline.get(i).isEmpty()) continue;
//
//                String word1 = dataline.get(i);
//                String word2 = dataline.get(i + 1);
//                if (!word1.equals(word2)){}
//                StringBuilder word22 = new StringBuilder(word2);
//                String word3 = word22.reverse().toString();
//                if (word1.equals(word3)){
//                    Pair pair = new Pair();
//                    pair.first = word1;
//                    pair.second = word2;
//                    result.add(pair);
//                    i = i + 1;
//                }
//            }

            for(int i = 0; i < dataline.size()-1; i++)
            {
                for(int j = 0; j < dataline.size()-1;)
                {
                        if (dataline.get(i).equals(new StringBuilder(dataline.get(j)).reverse().toString()) && i != j){
                            Pair pair = new Pair();
                            pair.first = dataline.get(i);
                            pair.second = dataline.get(j);
                            result.add(pair);
                            dataline.remove(i);
                            dataline.remove(j - 1);
                        }
                    else
                        j++;
                }
            }


            for (Pair p: result) {
                System.out.println(p.first + " "  + p.second);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
