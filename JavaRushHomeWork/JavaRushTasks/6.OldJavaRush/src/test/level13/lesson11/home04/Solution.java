package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter out = null;
        try {
            out = new FileWriter(reader.readLine());
            BufferedWriter output = new BufferedWriter(out);
            ArrayList<String> list = new ArrayList<String>();
            while (true){
                String num = reader.readLine();
                if (num.equals("exit")) break;
                list.add(num);
            }
            for(String r: list) {
                String s=r.toString();
                out.write(s+"\r\n");
            }
        } finally {
            out.close();
            reader.close();
        }
    }
}
