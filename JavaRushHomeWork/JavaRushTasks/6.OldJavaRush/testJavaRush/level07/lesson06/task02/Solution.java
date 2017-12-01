package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //viv(initArr());
        max(initArr());
        //напишите тут ваш код
    }

    public static void max(ArrayList<String> arr) {
        int a = 0;
        int t = 0;
        String s = null;

        for (int i = 0; i < arr.size(); i++) {
            if (a < arr.get(i).length()) {
                a = arr.get(i).length();
                t = i;
                s = arr.get(i);
            }
        }
        System.out.println(s);
        for (int i = 0; i < arr.size(); i++){
            if (a == arr.get(i).length() && t != i){
                System.out.println(arr.get(i));
            }
        }
    }
    public static ArrayList<String> initArr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ilya = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            ilya.add(i, reader.readLine());
        }
        return ilya;
    }
    /*
    public static void viv(ArrayList<String> arr){
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }*/
}
