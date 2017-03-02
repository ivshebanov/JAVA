package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> hum3 = new ArrayList<Human>();
        Human children1 = new Human("Masha", false, 5, hum3);
        Human children2 = new Human("Pasha", true, 10, hum3);
        Human children3 = new Human("Kira", false, 12, hum3);
        ArrayList<Human> hum = new ArrayList<Human>();
        hum.add(children1);
        hum.add(children2);
        hum.add(children3);
        Human father = new Human("Maks", true, 44, hum);
        Human mother = new Human("Lena", false, 40, hum);
        ArrayList<Human> hum1 = new ArrayList<Human>();
        hum1.add(father);
        Human grandFather1 = new Human("Vasia", true, 70, hum1);
        Human grandMother1 = new Human("Vasilisa", false, 69, hum1);
        ArrayList<Human> hum2 = new ArrayList<Human>();
        hum2.add(mother);
        Human grandFather2 = new Human("Misha", true, 71, hum2);
        Human grandMother2 = new Human("Dusia", false, 65, hum2);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
