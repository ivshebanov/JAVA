    package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        Reclama reclama = new Reclama(new ByteArrayOutputStream(), testString);
        reclama.zamena();
    }

    public static class Reclama extends PrintStream{
        private ByteArrayOutputStream out;
        private TestString testStr;

        public Reclama(ByteArrayOutputStream out, TestString testStr){
            super(out);
            this.out = out;
            this.testStr = testStr;
        }

        public void zamena(){
            PrintStream consolStream = System.out;
            System.setOut(new PrintStream(out));
            testStr.printSomething();
            String result = out.toString();
            out.reset();
            String[] str = result.split("\n");
            for (int i = 0; i < str.length; i++){
                System.out.println(str[i]);
                if(i % 2 == 1){
                    System.out.println("JavaRush - курсы Java онлайн");
                }
            }
            System.setOut(consolStream);
            System.out.println(out);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
