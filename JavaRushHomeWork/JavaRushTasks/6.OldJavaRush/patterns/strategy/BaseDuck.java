package patterns.strategy;

import patterns.strategy.fly.Fly;
import patterns.strategy.fly.FlyTrue;
import patterns.strategy.qryak.Qryak;
import patterns.strategy.qryak.QryakTrue;

/**
 * Created by iliashebanov on 25.09.16.
 */
public abstract class BaseDuck implements Fly, Qryak{

    protected Fly flyBe;
    protected Qryak qryakBe;

    BaseDuck(){
        flyBe = new FlyTrue();
        qryakBe = new QryakTrue();
    }
    abstract void Display();
    public void Swim(){
        System.out.println("Я умею плавать");
    }

    public void Fly(){
        flyBe.Fly();
    }
    public void Qryak(){
        qryakBe.Qryak();
    }

}
