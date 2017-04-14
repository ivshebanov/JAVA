package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties(
                "D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties(
                "D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties(
                "D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        File file = new File(fileName);
        if (!file.isFile()) {
            return properties;
        }
        try {
            if ((file.getName().toLowerCase()).endsWith(".xml")) {
                properties.loadFromXML(new FileInputStream(file));
            } else {
                properties.load(new FileInputStream(file));
            }
        } catch (Exception e) {
            return properties;
        }
        return properties;
    }
}
