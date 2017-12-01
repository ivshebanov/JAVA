package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        min(initArr());
    }
    public static void min(ArrayList<String> arr){
        int min = arr.get(0).length(), ind = 0;
        String s = arr.get(0);
        for (int i = 0; i < arr.size(); i++){
            if (min > arr.get(i).length()){
                min = arr.get(i).length();
                ind = i;
                s = arr.get(i);
            }
        }
        System.out.println(s);
        for (int i = 0; i < arr.size(); i++){
            if (min == arr.get(i).length() && ind != i){
                System.out.println(arr.get(i));
            }
        }
    }
    public static ArrayList<String> initArr() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> Ilya = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            Ilya.add(i, reader.readLine());
        }
        return Ilya;
    }
}
