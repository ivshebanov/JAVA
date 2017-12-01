package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Character> ert = new ArrayList<Character>();
        for (int j = 0; j < list.size(); j++) {
            String str = list.get(j);
            char[] Array = str.toCharArray();
            for (int r = 0; r < Array.length; r++) {
                ert.add(Array[r]);
            }
        }

        for (int i = 0; i < alphabet.size(); i++){
            int count = 0;
            for (int j = 0; j < ert.size(); j++){
                if (alphabet.get(i).equals(ert.get(j))) count++;
            }
            System.out.println(alphabet.get(i) + " " + count);
        }

        //напишите тут ваш код
        /*TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < alphabet.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < list.size(); j++)
            {
                String str = list.get(j);
                char[] Array = str.toCharArray();
                ArrayList<Character> ert = new ArrayList<Character>();
                for (int r = 0; r < Array.length; r++)
                {
                    ert.add(Array[r]);
                }
                for (int t = 0; t < ert.size(); t++)
                {
                    if (alphabet.get(i).equals(ert.get(t))) count++;
                }
            }
            map.put(alphabet.get(i).toString(), count);
        }

        for (Map.Entry l: map.entrySet()){
            System.out.println(l.getKey() + " " + l.getValue());
        }*/

    }

}
