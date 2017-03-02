package patterns.decoator;

import patterns.decoator.addition.HotCocolate;
import patterns.decoator.addition.Milk;
import patterns.decoator.addition.Suger;

/**
 * Created by iliashebanov on 26.09.16.
 * Pettern Decorator
 * Реализация на примере с кофейней. Есть базовые напитки: Espresso, GreenTee, BlackTee.
 * К базовым напиткам мы можем добавлять различные добавки, такие как: Milk, Sugar, HotChocolate.
 * При такой реализации базовые напитки не зависят от добавок, и мы можем добавлять как долнительные
 * напитки так и добавки к ним.
 */
public class Solution {
    public static void main(String[] arg){
        BavarageBase esspreso = new Esspreso();
        BavarageBase greenTee = new GreenTee();
        BavarageBase blackTee = new BlackTee();

        print(esspreso);
        print(greenTee);
        print(blackTee);
        System.out.println("");

        BavarageBase hotchoc = new HotCocolate(new Esspreso());
        BavarageBase capuchino = new Suger(new Milk(new Esspreso()));
        BavarageBase cff = new Suger(new BlackTee());

        print(hotchoc);
        print(capuchino);
        print(cff);
    }

    private static void print(BavarageBase b){
        System.out.println("Bavarage: " + b.GetDiscription() + ". Price: " + b.GetCount());
    }
}
