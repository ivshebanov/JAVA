package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            //D:\Hotj\Dropbox\JAVA\JavaRushHomeWork\JavaRushHomeWork\src\com\javarush\test\level22\lesson09\task03\file
            reader.close();
            String str = "";
            while(fileReader.ready()){
                str = str + fileReader.readLine();
            }
            fileReader.close();

            if (!str.equals("")){
                String[] strArr = str.split(" ");
                StringBuilder result = getLine(strArr);
                System.out.println(result.toString());
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] word = words;
        String firstSymbol = null;
        String secondSymbol = null;
        while (word.length != 0){
            for (int i = 0; i < word.length; i++){
                if (firstSymbol != null & secondSymbol != null){
                    if (firstSymbol.equals(word[i].substring(word[i].length() - 1).toLowerCase())){
                        stringBuilder.insert(0, word[i] + " ");
                        firstSymbol = word[i].substring(0, 1).toLowerCase();
                        word = remove(word, i);
                    }else if(secondSymbol.equals(word[i].substring(0, 1).toLowerCase())){
                        stringBuilder.insert(stringBuilder.length(), " " + word[i]);
                        secondSymbol = word[i].substring(word[i].length() - 1).toLowerCase();
                        word = remove(word, i);
                    }
                }
                if (stringBuilder.length() == 0){
                    stringBuilder.append(word[i]);
                    firstSymbol = word[i].substring(0, 1).toLowerCase();
                    secondSymbol = word[i].substring(word[i].length() - 1).toLowerCase();
                    word = remove(word, i);
                }
            }
        }
        return stringBuilder;
    }

    public static String[] remove(String[] symbols, int index)
    {
        if (index >= 0 && index < symbols.length)
        {
            String[] copy = new String[symbols.length-1];
            System.arraycopy(symbols, 0, copy, 0, index);
            System.arraycopy(symbols, index+1, copy, index, symbols.length-index-1);
            return copy;
        }
        return symbols;
    }
}
