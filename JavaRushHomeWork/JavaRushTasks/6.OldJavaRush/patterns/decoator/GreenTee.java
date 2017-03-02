package patterns.decoator;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class GreenTee extends BavarageBase {

    public GreenTee(){
        Discription = "GreenTee";
    }
    @Override
    public double GetCount()
    {
        return 70;
    }
}
