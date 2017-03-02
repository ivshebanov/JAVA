package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level18/lesson05/task03/file
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        OutputStream outputStream1 = new FileOutputStream(reader.readLine());
        OutputStream outputStream2 = new FileOutputStream(reader.readLine());
        reader.close();
        int val = inputStream.available()/2;
        byte[] buff = new byte[val];
        if (inputStream.available()%2==0){
            while (inputStream.available()>0){
                if (inputStream.available()>val){
                    int count = inputStream.read(buff);
                    outputStream1.write(buff, 0, count);
                }
                if (inputStream.available()<=val){
                    int count = inputStream.read(buff);
                    outputStream2.write(buff, 0, count);
                }
            }
        }else {
            while (inputStream.available()>0){
                if (inputStream.available()>val){
                    int count = inputStream.read(buff);
                    outputStream1.write(buff, 0, count);
                    outputStream1.write(inputStream.read());
                }
                if (inputStream.available()<=val){
                    int count = inputStream.read(buff);
                    outputStream2.write(buff, 0, count);
                }
            }
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
