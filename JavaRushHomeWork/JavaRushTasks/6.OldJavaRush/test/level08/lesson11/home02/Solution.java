package com.javarush.test.level08.lesson11.home02;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.*;

/* Множество всех животных
1. Внутри класса index создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов,
которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных,
которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());

        return result;
    }

    public static Set<Dog> createDogs()
    {
        //напишите тут ваш код
        HashSet<Dog> res = new HashSet<Dog>();
        res.add(new Dog());
        res.add(new Dog());
        res.add(new Dog());
        return res;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        Set<Objects> pets = new HashSet<Objects>();
        pets.addAll((HashSet)cats);
        pets.addAll((HashSet)dogs);

        return (HashSet)pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
        Iterator<Cat> car = cats.iterator();
        while (car.hasNext()){
            Cat c = car.next();

            Iterator<Object> itr = pets.iterator();
            while(itr.hasNext()) {
                Object d = itr.next();
                if (d.equals(c)) itr.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets)//вывод
    {
        //напишите тут ваш код
        Iterator<Object> iterator = pets.iterator();

        while (iterator.hasNext())        //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            Object text = iterator.next();

            System.out.println(text);
        }
    }

    //напишите тут ваш код

    public static class Cat{

    }
    public static class Dog {

    }
}
