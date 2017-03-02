package patterns.decoator;

/**
 * Created by iliashebanov on 26.09.16.
 */
public class Esspreso extends BavarageBase {

    public Esspreso(){
        Discription = "Esspreso";
    }
    @Override
    public double GetCount()
    {
        return 100;
    }
}
