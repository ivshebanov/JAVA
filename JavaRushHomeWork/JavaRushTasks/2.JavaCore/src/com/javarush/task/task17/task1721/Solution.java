package com.javarush.task.task17.task1721;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            String fileName2 = reader.readLine();
//            String fileName = "D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task17\\task1721\\file";
//            String fileName2 = "D:\\Hotj\\JAVA\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task17\\task1721\\file2";

            allLines = Files.readAllLines(Paths.get(fileName));
            forRemoveLines = Files.readAllLines(Paths.get(fileName2));
            solution.joinData();
            reader.close();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (String line : forRemoveLines) {
                allLines.remove(line);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
