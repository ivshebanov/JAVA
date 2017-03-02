package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum = reader.readLine();
        int num = Integer.parseInt(sNum);

        swNed(num);
    }

    public static void ned(int a){
        if(a >= 1){
            if(a <= 7){
                if(1 == a){
                    System.out.println("понедельник");
                }else{
                    if(2 == a){
                        System.out.println("вторник");
                    }else{
                        if(3 == a){
                            System.out.println("среда");
                        }else{
                            if(4 == a){
                                System.out.println("четверг");
                            }else{
                                if(5 == a){
                                    System.out.println("пятница");
                                }else{
                                    if(6 == a){
                                        System.out.println("суббота");
                                    }else{
                                        if(7 == a){
                                            System.out.println("воскресенье");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                System.out.println("такого дня недели не существует");
            }
        }else{
            System.out.println("такого дня недели не существует");

        }
    }
    public static void swNed(int a){
        switch(a){
            case(1):{
                System.out.println("понедельник");
                return;
            }
            case(2):{
                System.out.println("вторник");
                return;
            }
            case(3):{
                System.out.println("среда");
                return;
            }
            case(4):{
                System.out.println("четверг");
                return;
            }
            case(5):{
                System.out.println("пятница");
                return;
            }
            case(6):{
                System.out.println("суббота");
                return;
            }
            case(7):{
                System.out.println("воскресенье");
                return;
            }
            default:{
                System.out.println("такого дня недели не существует");
            }
        }
    }


}