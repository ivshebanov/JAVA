package patterns.strategy;

import java.util.ArrayList;

/**
 * Created by iliashebanov on 25.09.16.
 */
public class Solution {
    public static void main(String[] arg){
        ArrayList<BaseDuck> duck = new ArrayList<BaseDuck>();
        duck.add(new ExoticDack());
        duck.add(new SimpleDuck());
        duck.add(new RubberDuck());
        duck.add(new WoodenDuck());

        for (BaseDuck d: duck){
            d.Display();
            d.Swim();
            d.Fly();
            d.Qryak();
            System.out.println("");
        }
    }
}
