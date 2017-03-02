package patterns.decoator.addition;

import patterns.decoator.BavarageBase;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class HotCocolate extends AdditionBavarage{

    private BavarageBase bavarage;

    public HotCocolate(BavarageBase bavarage1){
        bavarage = bavarage1;
        Discription = bavarage.GetDiscription() + " + HotCocolate";
    }
    @Override
    public double GetCount()
    {
        return bavarage.GetCount() + 70;
    }
}
