package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    //D:\Hotj\Dropbox\JAVA\JavaRushHomeWork\JavaRushHomeWork\src\com\javarush\test\level22\lesson13\task02\file
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(new File(args[1]));
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        outputStream.write(new String(buffer, utf8).getBytes(windows1251));
        inputStream.close();
        outputStream.close();
    }
}
