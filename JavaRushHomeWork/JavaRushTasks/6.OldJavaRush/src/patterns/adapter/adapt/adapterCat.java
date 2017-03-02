package patterns.adapter.adapt;

import patterns.adapter.homeCat.HomeCat;
import patterns.adapter.wildCat.WildCat;

/**
 * Created by iliashebanov on 03.10.16.
 */
public class adapterCat implements HomeCat
{
    private WildCat cat;
    public adapterCat(WildCat catq){
        cat = catq;
    }
    @Override
    public String name()
    {
        return cat.klichka();
    }

    @Override
    public void mew()
    {
        cat.growl();
    }

    @Override
    public void scratch()
    {
        cat.rip();
    }
}
