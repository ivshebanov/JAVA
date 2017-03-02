package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement traceElement[] = new Throwable().getStackTrace();
        if (traceElement.length > 1){
            StackTraceElement element = traceElement[1];
            System.out.format("%s: %s: %s", element.getClassName(), element.getMethodName(), s);
        }
    }
}
