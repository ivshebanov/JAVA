package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        System.out.println(ExceptionFactory.getException(ExceptionUserMessage.USER_DOES_NOT_EXIST).getMessage());
        System.out.println(ExceptionFactory.getException(ExceptionApplicationMessage.SOCKET_IS_CLOSED).getMessage());
        System.out.println(ExceptionFactory.getException(ExceptionApplicationMessage.UNHANDLED_EXCEPTION).getMessage());
        System.out.println(ExceptionFactory.getException(ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS).getMessage());
    }
}