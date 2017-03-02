package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке


1 фыв фыав а 3.23 3
2 ячмсч чсм 2.123 4
4 выа ыва в 2.1111 5


/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson10/home07/file1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson10/home07/file1";
        String id = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        reader.close();
        String str;
        while ((str = fileReader.readLine()) != null){
            String[] lines = str.split(" ");
            if (id.equals(lines[0])) System.out.println(str);
        }
        fileReader.close();
    }
}
