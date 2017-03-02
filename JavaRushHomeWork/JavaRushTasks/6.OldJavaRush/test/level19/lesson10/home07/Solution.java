package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
длинное короткое аббревиатура werw wesdds вованч

*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            FileWriter fileWriter = new FileWriter(args[1]);
            String str = "";
            while (fileReader.ready()) {
                str = str + fileReader.readLine() + " ";
            }
            Pattern pattern = Pattern.compile("\\S\\S\\S\\S\\S\\S\\S+");
            Matcher matcher = pattern.matcher(str);
            boolean flag = false;
            while (matcher.find()){
                if (flag){
                    fileWriter.write("," + str.substring(matcher.start(), matcher.end()));
                }else {
                    flag = true;
                    fileWriter.write(str.substring(matcher.start(), matcher.end()));
                }
            }

            fileReader.close();
            fileWriter.close();
        }catch (FileNotFoundException ex1){
        }catch (IOException ex2){
        }
    }
}
