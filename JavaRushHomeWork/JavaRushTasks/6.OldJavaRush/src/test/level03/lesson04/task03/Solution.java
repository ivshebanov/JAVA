package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        Zerg zerg6 = new Zerg();
        Zerg zerg7 = new Zerg();
        Zerg zerg8 = new Zerg();
        Zerg zerg9 = new Zerg();
        Zerg zerg10 = new Zerg();

        zerg1.name = "Vas1";
        zerg2.name = "Vas2";
        zerg3.name = "Vas3";
        zerg4.name = "Vas4";
        zerg5.name = "Vas5";
        zerg6.name = "Vas6";
        zerg7.name = "Vas7";
        zerg8.name = "Vas8";
        zerg9.name = "Vas9";
        zerg10.name = "Vas10";

        Protos protos1 = new Protos();
        Protos protos2 = new Protos();
        Protos protos3 = new Protos();
        Protos protos4 = new Protos();
        Protos protos5 = new Protos();

        protos1.name = "cat1";
        protos2.name = "cat2";
        protos3.name = "cat3";
        protos4.name = "cat4";
        protos5.name = "cat5";

        Terran terran1 = new Terran();
        Terran terran2 = new Terran();
        Terran terran3 = new Terran();
        Terran terran4 = new Terran();
        Terran terran5 = new Terran();
        Terran terran6 = new Terran();
        Terran terran7 = new Terran();
        Terran terran8 = new Terran();
        Terran terran9 = new Terran();
        Terran terran10 = new Terran();
        Terran terran11 = new Terran();
        Terran terran12 = new Terran();

        terran1.name = "dog1";
        terran2.name = "dog2";
        terran3.name = "dog3";
        terran4.name = "dog4";
        terran5.name = "dog5";
        terran6.name = "dog6";
        terran7.name = "dog7";
        terran8.name = "dog8";
        terran9.name = "dog9";
        terran10.name = "dog10";
        terran11.name = "dog11";
        terran12.name = "dog12";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}