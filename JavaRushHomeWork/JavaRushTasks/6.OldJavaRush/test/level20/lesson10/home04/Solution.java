package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса index.html обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {
    //private static final long serialVersionUID = 170501993;

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream(new File("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home04\\file.tmp"));
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        System.out.println(solution.size());
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home04\\file.tmp");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
