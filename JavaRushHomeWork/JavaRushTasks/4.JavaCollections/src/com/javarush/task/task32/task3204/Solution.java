package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
        Pattern pattern1 = Pattern.compile(".*[0-9].*");
        Pattern pattern2 = Pattern.compile(".*[A-Z].*");
        Pattern pattern3 = Pattern.compile(".*[a-z].*");
        Boolean check = true;
        String newPass;
        while (check){
            newPass = getPass();
            Matcher matcher1 = pattern1.matcher(newPass);
            Matcher matcher2 = pattern2.matcher(newPass);
            Matcher matcher3 = pattern3.matcher(newPass);
            if (matcher1.matches() && matcher2.matches() && matcher3.matches()){
                try {
                    baos.write(newPass.getBytes());
                    check = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos;
    }

    private static String getPass() {
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randString;
        randString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            randString.append(symbols.charAt(new Random().nextInt(symbols.length())));
        }
        return randString.toString();
    }
}