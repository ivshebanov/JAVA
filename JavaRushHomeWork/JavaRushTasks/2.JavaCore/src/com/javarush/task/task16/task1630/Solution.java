package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
//            firstFileName = "/Users/iliashebanov/Documents/JAVA/JavaRushHomeWork/JavaRushTasks/2.JavaCore/src/com/javarush/task/task16/task1630/file1";
//            secondFileName = "/Users/iliashebanov/Documents/JAVA/JavaRushHomeWork/JavaRushTasks/2.JavaCore/src/com/javarush/task/task16/task1630/file2";
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private BufferedReader reader;
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            try {
                reader = new BufferedReader(new FileReader(fullFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            try {
                while (reader.ready()) {
                    fileContent = fileContent + reader.readLine() + " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
