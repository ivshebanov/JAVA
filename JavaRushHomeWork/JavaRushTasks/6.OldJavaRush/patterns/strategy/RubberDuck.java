package patterns.strategy;

import patterns.strategy.fly.FlyFalse;

/**
 * Created by iliashebanov on 25.09.16.
 */
public class RubberDuck extends BaseDuck {
    RubberDuck(){
        flyBe = new FlyFalse();
    }
    @Override
    void Display() {
        System.out.println("RubberDuck утка");
    }
}
