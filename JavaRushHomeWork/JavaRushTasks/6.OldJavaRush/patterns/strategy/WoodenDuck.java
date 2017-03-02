package patterns.strategy;

import patterns.strategy.fly.FlyFalse;
import patterns.strategy.qryak.QryakFalse;

/**
 * Created by iliashebanov on 25.09.16.
 */
public class WoodenDuck extends BaseDuck {
    WoodenDuck(){
        flyBe = new FlyFalse();
        qryakBe = new QryakFalse();
    }
    @Override
    void Display() {
        System.out.println("WoodenDuck утка");
    }
}
