package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //Add your code here
        try {
            int[] mas2  = new int[3];
            for (int i = 0; i < 10; i++){
                mas2[i] = 1;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        //
        try {
            throw new NumberFormatException();
        }catch (NumberFormatException e){
            exceptions.add(e);
        }
        //
        try {
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            exceptions.add(e);
        }
        //
        try {
            throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException e){
            exceptions.add(e);
        }
        //
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){
            exceptions.add(e);
        }
        //
        try {
            throw new SocketException();
        }catch (SocketException e){
            exceptions.add(e);
        }
        //
        try {
            throw new FileNotFoundException();
        }catch (FileNotFoundException e){
            exceptions.add(e);
        }
        //
        try {
            throw new IOException();
        }catch (IOException e){
            exceptions.add(e);
        }
        //
        try {
            throw new Exception();
        }catch (Exception e){
            exceptions.add(e);
        }
    }
}
