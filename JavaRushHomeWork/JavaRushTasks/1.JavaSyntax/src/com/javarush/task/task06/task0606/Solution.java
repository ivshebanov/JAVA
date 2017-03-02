package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.ArrayList;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(a>0) {
            list.add(a%10);
            a = a / 10;
        }
        for (Integer w: list){
            if (w%2==0){
                even++;
            }else {
                odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
