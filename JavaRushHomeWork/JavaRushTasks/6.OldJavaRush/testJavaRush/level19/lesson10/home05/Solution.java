package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources

a1 ab3c wew nnio34f 3ffr 4 weijfwo 123w 12341 qews
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            FileWriter fileWriter = new FileWriter(args[1]);
            while (fileReader.ready()){
                String str = fileReader.readLine();
                Pattern pattern = Pattern.compile("\\b(\\S*\\d+\\S*)+\\b");
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()){
                    fileWriter.write(str.substring(matcher.start(), matcher.end())+" ");
                    //System.out.print(str.substring(matcher.start(), matcher.end())+" ");
                }
            }
            fileReader.close();
            fileWriter.close();
        }catch (FileNotFoundException ex1){
        }catch (IOException ex2){
        }
    }
}
