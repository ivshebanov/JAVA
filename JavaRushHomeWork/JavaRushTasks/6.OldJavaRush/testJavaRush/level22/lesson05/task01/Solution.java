package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args)
    {
        try
        {
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }
        catch (TooShortStringException e)
        {
            e.printStackTrace();
        }
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String str = "";
        int count = 0;
        String[] strArr = null;

        if (string == null) throw new TooShortStringException();
        for (char element : string.toCharArray()){
                if (element == ' ') count++;
        }
        if (count < 4) throw new TooShortStringException();

        strArr = string.split(" ");
        str = strArr[1] + " " + strArr [2] + " " + strArr[3] + " " + strArr[4];

        return str;
    }

    public static class TooShortStringException extends Exception {

    }

}
