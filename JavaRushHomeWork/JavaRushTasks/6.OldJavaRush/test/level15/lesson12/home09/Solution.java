package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14


javarush.ru/alpha/index.html.html?obj=р.14&name=Amigo
javarush.ru/alpha/index.html.html?lvl=15&view&name=Amigo&obj=3.14&name=27.87
javarush.ru/alpha/index.html.html?obj=.
javarush.ru/alpha/index.html.html?obj&name=Amigo
javarush.ru/alpha/index.html.html?lvl=15&view&name=Amigo&obj=-2.6&obj=-9.8h
javarush.ru/alpha/index.html.html?lvl=15&view&name=Amigoobj=3.14
a.ua?oobj=fff
javarush.ru/index.html.php?op=none&obj=3.5test
javarush.ru/index.html.php?op=none&obj=3.5=test
javarush.ru/index.html.php?op=none&&&obj=3.5test
blablabla.ru/index.html.html?obj=er.uj
javarush.ru/alpha/index.html.html?obj=ghj?jlkj&view
javarush.ru/index.html.php?op=none&obj=3.5test????
javarush.ru/index.html.php????op=none&?&&&?&&&&&??obj=3.5test&obj=3.5????
javarush.ru/alpha/index.html.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0
obj.javarush.ru/?op=obj&&obj=3&obj=3.3.3&values=5&object=this&obj=&oobj=7.7
obj.javarush.ru/?op=obj&&obj=3&obj=.3&values=5&object=this&obj=&oobj=7.7
obj=movie.avi

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        ArrayList<String> meaningObj = new ArrayList<String>(); //значения obj
        ArrayList<String> parametrs = new ArrayList<String>();
        Pattern pattern3 = Pattern.compile("[\\&|\\?]obj=([\\+|\\-]?[\\w]*[\\.]?)+");
        Matcher matcher3 = pattern3.matcher(url);
        while (matcher3.find()){
            String parametr = url.substring(matcher3.start()+5, matcher3.end());
            meaningObj.add(parametr);
        }
        Pattern pattern = Pattern.compile("[\\&|\\?][a-z]+");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()){
            String itog = url.substring(matcher.start()+1, matcher.end());
            parametrs.add(itog);
        }
        for (String p: parametrs){
            System.out.print(p + " ");
        }
        System.out.println();
        for (String m: meaningObj){
            if((!m.equals("")&&(!m.equals(".")))){
                if(m.matches("[\\+|\\-]?[\\d]*[\\.]?[\\d]*")) {
                    alert(Double.parseDouble(m));
                }else {
                    alert(m);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
