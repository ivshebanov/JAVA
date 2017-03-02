package patterns.decoator;

/**
 * Created by iliashebanov on 26.09.16.
 */
public abstract class BavarageBase {

    protected String Discription = null;

    public String GetDiscription(){
        return Discription;
    }
    public abstract double GetCount();

}
