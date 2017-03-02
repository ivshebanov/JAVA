package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable index.html
Сериализуйте класс index.html.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса index.html - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса index.html с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson07\\task04\\file.tmp")));
            Solution savedObject = new Solution(8);
            //System.out.println(savedObject);
            objectOutputStream.writeObject(savedObject);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson07\\task04\\file.tmp"));
            Solution loadedObject = new Solution(16);
            //System.out.println(loadedObject);
            loadedObject = (Solution) objectInputStream.readObject();
            //System.out.println(loadedObject);
            System.out.println(savedObject.string.equals(loadedObject.string) ? true : false);

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
