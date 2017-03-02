package patterns.decoator;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class BlackTee extends BavarageBase{

    public BlackTee(){
        Discription = "BlackTee";
    }

    @Override
    public double GetCount()
    {
        return 40;
    }
}
