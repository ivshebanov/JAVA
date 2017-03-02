package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = null;
        try {
            if (!(args[0]==null)) inputStream = new FileInputStream(args [0]);
        }catch (Exception e){
            e.getStackTrace();
        }
        int space = 0;
        int count = 0;
        assert inputStream != null;
        while (inputStream.available() > 0){
            count++;
            if (inputStream.read() == ' ')space++;
        }

        System.out.print(String.format("%.2f",(float)(space*100)/count));

//        System.out.printf("%.2f", probel/count*100.0);
        inputStream.close();
    }
}
