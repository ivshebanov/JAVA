package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

//    public static void main(String[] args) {
//        OutputStream outputStream = null;
//        try {
//            fillInPropertiesMap();
//            System.out.println(properties.size());
//            outputStream = new FileOutputStream(new File("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson02\\task03\\file.properties"));
//            save(outputStream);
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//        catch (Exception e) {
//            System.out.println("Ошиба чтения из входного потока outputStream");
//        }
//        finally {
//            try {
//                outputStream.close();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public void fillInPropertiesMap() {
        BufferedReader reader = null;
        InputStream inputStream = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String url = reader.readLine();
            //String url1 = "D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson02\\task03\\file.txt";
            inputStream = new FileInputStream(url);
            load(inputStream);
            reader.close();
            inputStream.close();
        }catch (IOException ex){
            //System.out.println("Ошибка ввода url");
        }catch (Exception ex1){
            //System.out.println("Ошиба чтения из входного потока inputStream");
        }
//        finally {
//            try {
//                reader.close();
//                inputStream.close();
//            }catch (Exception ex){
//                System.out.println("Ошибка закрытия потоков reader/inputStream");
//            }
//        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties pro = new Properties();
        for (Map.Entry<String, String> el: properties.entrySet()){
            pro.setProperty(el.getKey(), el.getValue());
        }
        pro.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties pro = new Properties();
        pro.load(inputStream);
        Enumeration enumeration = pro.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = (String) enumeration.nextElement();
            String value = pro.getProperty(key);
            properties.put(key, value);
        }
        inputStream.close();
    }
}
