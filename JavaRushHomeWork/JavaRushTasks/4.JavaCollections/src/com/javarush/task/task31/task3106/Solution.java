package com.javarush.task.task31.task3106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length < 2){
            return;
        }
        String resultFileName = args[0];

        List<String> listArgs = new ArrayList<>();

        for (int i = 1; i < args.length; i++){
            listArgs.add(args[i]);
        }
        listArgs.sort(Comparator.comparing(String::isEmpty));
    }
}
