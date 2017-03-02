package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4

3.49 3.50 3.51 -3.49 -3.50 -3.51 5973.49 5973.50 5973.51

/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson10/home05/file1
*/


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        String str;
        String[] strMass;
        double tmp;

        while ((str = fileReader.readLine()) != null) {
            strMass = str.split(" ");
            for (String strMas : strMass)
            {
                tmp = Math.round(Double.parseDouble(strMas));
                numbers.add((int)tmp);
            }
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String num = "";
        for (int a : numbers)
            num = num+a+" ";
        fileWriter.write(num);
        fileWriter.close();

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile1));
        String str = fileReader.readLine();
        fileReader.close();
        if (str == null) throw new FileNotFoundException();

        Pattern pattern = Pattern.compile("[\\-]?\\d*\\.\\d*");
        Matcher matcher = pattern.matcher(str);
        ArrayList<Double> znach = new ArrayList<Double>();
        while (matcher.find()){
            znach.add(Double.valueOf(str.substring(matcher.start(), matcher.end())));
        }

        ArrayList<String> znach2 = new ArrayList<String>();
        for (Double d: znach){
            znach2.add(Long.toString(Math.round(d)) + " ");
        }

        OutputStream outputStream = new FileOutputStream(nameFile2);
        for (String s: znach2){
            outputStream.write(s.getBytes());
        }
        outputStream.close();

//        FileWriter fileWriter = new FileWriter(nameFile2);
//        for (Integer d: znach2){
//            fileWriter.write(d);
//        }
//        fileWriter.close();*/
    }
}
