package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
//        StringBuilder jsonString = new StringBuilder();
//        List<String> list = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
//        for (String s : list) {
//            jsonString.append(s);
//        }
//        StringReader stringReader = new StringReader(jsonString.toString());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(new File(fileName)), clazz);
    }

    public static void main(String[] args) {
        String str = "D:\\hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task33\\task3303\\123.json";
        try {
            Ilya ilya = convertFromJsonToNormal(str, Ilya.class);
            System.out.println(ilya.getName());
            System.out.println(ilya.getWeight());
            System.out.println(ilya.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
