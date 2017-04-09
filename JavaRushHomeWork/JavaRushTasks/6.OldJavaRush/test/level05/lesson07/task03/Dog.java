package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String name;
    private int growth;
    private String colour;

    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int growth){
        this.name = name;
        this.growth = growth;
    }
    public void initialize(String name, int growth, String colour){
        this.name = name;
        this.growth = growth;
        this.colour = colour;
    }
}
