package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);

        checkSeason(1);
        checkSeason(13);
        checkSeason(-4);

    }

    public static void checkSeason(int mount){
        //::CODE:
        if(mount > 0)
        {
            if (mount <= 12)
            {
                if(mount < 3){
                    System.out.println("зима");
                }else{
                    if(mount < 6){
                        System.out.println("весна");
                    }else{
                        if(mount < 9){
                            System.out.println("лето");
                        }else{
                            if(mount < 12){
                                System.out.println("осень");
                            }else{
                                if(12 == mount){
                                    System.out.println("зима");
                                }
                            }
                        }
                    }
                }

            } else {
                System.out.println("Такого месяца нет");
            }
        }else{
            System.out.println("Такого месяца нет");
        }
    }



/*
        switch (mount){
            case (12):{
                System.out.println("Зима");
                return;
            }
            case (1):{
                System.out.println("Зима");
                return;
            }
            case (2):{
                System.out.println("Зима");
                return;
            }
            case (3):{
                System.out.println("Весна");
                return;
            }
            case (4):{
                System.out.println("Весна");
                return;
            }
            case (5):{
                System.out.println("Весна");
                return;
            }
            case (6):{
                System.out.println("Лето");
                return;
            }
            case (7):{
                System.out.println("Лето");
                return;
            }
            case (8):{
                System.out.println("Лето");
                return;
            }
            case (9):{
                System.out.println("Осень");
                return;
            }
            case (10):{
                System.out.println("Осень");
                return;
            }
            case (11):{
                System.out.println("Осень");
                return;
            }
            default:{
                System.out.println("Такого месяца нет");
                return;
            }
        }
*/
}
