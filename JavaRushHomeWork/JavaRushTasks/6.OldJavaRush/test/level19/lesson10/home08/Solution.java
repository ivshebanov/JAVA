package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА

/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson10/home08/file
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            while (fileReader.ready()){
                PrintStream consoleStream = System.out;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                System.out.print(fileReader.readLine());
                String result = outputStream.toString();
                System.setOut(consoleStream);
                StringBuilder stringBuilder = new StringBuilder(result);
                System.out.println(stringBuilder.reverse().toString());
            }
            reader.close();
            fileReader.close();
        }catch (IOException ex1){
        }
    }
}
