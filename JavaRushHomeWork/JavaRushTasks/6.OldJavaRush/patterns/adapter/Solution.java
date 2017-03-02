package patterns.adapter;

import patterns.adapter.adapt.adapterCat;
import patterns.adapter.homeCat.HomeCat;
import patterns.adapter.homeCat.MeinCyn;
import patterns.adapter.homeCat.Syamskyi;
import patterns.adapter.wildCat.Tiger;

import static patterns.adapter.PrintCat.printCat;


/**
 * Created by iliashebanov on 03.10.16.
 */
public class Solution
{
    public static void main(String[] args)
    {
        HomeCat cat1 = new MeinCyn();
        HomeCat cat2 = new Syamskyi();
        printCat(cat1);
        printCat(cat2);

        HomeCat cat3 = new adapterCat(new Tiger());
        printCat(cat3);
    }
}
