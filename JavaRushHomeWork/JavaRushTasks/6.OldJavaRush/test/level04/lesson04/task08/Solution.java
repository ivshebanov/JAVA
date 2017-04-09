package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine();
        String sb = reader.readLine();
        String sc = reader.readLine();

        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int c = Integer.parseInt(sc);
        triangle2(a, b, c);
    }

    public static void triangle(int a, int b, int c){
        if(a + b > c){
            if(a + c > b){
                if(c + b > a){
                    System.out.println("Треугольник существует.");
                }else{
                    System.out.println("Треугольник не существует.");
                }
            }else{
                System.out.println("Треугольник не существует.");
            }
        }else{
            System.out.println("Треугольник не существует.");
        }
    }

    public static void triangle2(int a, int b, int c){
        if((a + b > c) && (a + c > b) && (c + b > a)){
            System.out.println("Треугольник существует.");
        }else{
            System.out.println("Треугольник не существует.");
        }
    }
}