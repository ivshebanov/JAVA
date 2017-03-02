package patterns.adapter;

import patterns.adapter.homeCat.HomeCat;

/**
 * Created by iliashebanov on 03.10.16.
 */
public class PrintCat
{
    public static void printCat(HomeCat cat){
        System.out.println("Кот: " + cat.name());
        System.out.print("Мяуканье: ");
        cat.mew();
        System.out.print("Царапанье: ");
        cat.scratch();
        System.out.println(" ");
    }
}
