package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = new FileInputStream(args[0]);
        Pattern pt = Pattern.compile("[a-zA-z]");
        int count = 0;
        while (inputStream.available()>0){
            String sign = String.valueOf((char)inputStream.read());
            Matcher m = pt.matcher(sign);
            if (m.matches())count++;
        }
        System.out.println(count);
        inputStream.close();
    }
}
