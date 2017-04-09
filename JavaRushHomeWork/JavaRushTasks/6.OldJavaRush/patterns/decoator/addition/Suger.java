package patterns.decoator.addition;

import patterns.decoator.BavarageBase;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class Suger extends AdditionBavarage{

    private BavarageBase bavarage;

    public Suger(BavarageBase bavarage1){
        bavarage = bavarage1;
        Discription = bavarage.GetDiscription() + " + Suger";
    }
    @Override
    public double GetCount()
    {
        return bavarage.GetCount() + 10;
    }
}
