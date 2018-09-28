package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object a = new A();
        B b = (B) a;
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.equals("");
    }

    public static void main(String[] args) {
       VeryComplexClass vcc = new VeryComplexClass();
       vcc.methodThrowsClassCastException();
    }

    class A {
    }

    class B extends A {
    }
}
