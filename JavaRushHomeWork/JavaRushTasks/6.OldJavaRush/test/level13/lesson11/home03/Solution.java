package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        sChtenie();
    }
    private static void sChtenie() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = null;
        PrintStream out = null;
        try {
            String inName = reader.readLine();
            in = new FileInputStream(inName);
            out = new PrintStream(System.out, true, "UTF-8");
            while (in.available()>0){
                int mInt = in.read();
                out.write((char) mInt);
            }
            in.close();
            reader.close();
            out.close();
        }catch (IOException e){
            System.out.println("Такого файла нет.");
        }
    }
}
