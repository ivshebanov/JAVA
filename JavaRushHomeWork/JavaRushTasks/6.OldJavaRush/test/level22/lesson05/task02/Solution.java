package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        String itog = "";
        String newStr = string;
        int i = 0, count = 0;
        if (string == null) throw new TooShortStringException();
        while (true){
            i = newStr.indexOf("\t");
            if (i != -1 & count <= 3){
                count++;
            }else break;
            newStr = newStr.substring(i+1);
        }
        if (i != 0 & count < 2) throw new TooShortStringException();
        itog = string.substring(string.indexOf("\t"), string.indexOf("\t" , string.indexOf("\t")+1));
        itog = itog.trim();
        return itog;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
