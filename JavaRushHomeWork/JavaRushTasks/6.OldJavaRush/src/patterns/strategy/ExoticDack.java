package patterns.strategy;

import patterns.strategy.qryak.Mymy;

/**
 * Created by iliashebanov on 25.09.16.
 */
public class ExoticDack extends BaseDuck {
    ExoticDack(){
        qryakBe = new Mymy();
    }
    @Override
    void Display() {
        System.out.println("ExoticDack утка");
    }
}
