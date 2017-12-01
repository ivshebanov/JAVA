package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(result);
        int i = 0, t =0;
        while (matcher.find()){
            int num = Integer.parseInt(result.substring(matcher.start(), matcher.end()));
            if (result.contains("+")){
                if (t!=0){
                    i = t + num;
                }
            }else if (result.contains("-")){
                if (t!=0){
                    i = t - num;
                }
            }else if (result.contains("*")){
                if (t!=0){
                    i = t * num;
                }
            }
            t = num;
        }
        System.setOut(printStream);
        String[] resultArray = result.split(" ");
        System.out.println(resultArray[0] + " " + resultArray[1] + " " + resultArray[2] + " " + resultArray[3] + " " + i);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
            //System.out.println("3 - 6 = ");
            //System.out.println("3 * 6 = ");
        }
    }
}

