package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

D:\Hotj\Dropbox\JAVA\JavaRushHomeWork\JavaRushHomeWork\src\com\javarush\test\level19\lesson10\home04\file

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args)
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            //String fileName = "D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson10\\home04\\file";
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()){
                String str = fileReader.readLine();
                String[] strMass = str.split(" ");
                int count = 0;
                for (String s: words){
                    for (int i = 0; i<strMass.length; i++){
                        if (s.equals(strMass[i])){
                            count++;
                        }
                    }
                }
                if (2 == count){
                    System.out.println(str);
                }
            }
            reader.close();
            fileReader.close();
        }catch (FileNotFoundException ex1){
        }catch (IOException ex2){
        }
    }
}
