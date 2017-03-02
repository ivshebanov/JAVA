package patterns.decoator.addition;

import patterns.decoator.BavarageBase;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class Milk extends AdditionBavarage{

    private BavarageBase bavarage;

    public Milk(BavarageBase bavarage1){
        bavarage = bavarage1;
        Discription = bavarage.GetDiscription() + " + Milk";
    }
    @Override
    public double GetCount()
    {
        return bavarage.GetCount() + 40;
    }
}
