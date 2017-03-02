package patterns.adapter.wildCat;

/**
 * Created by iliashebanov on 03.10.16.
 */
public class Tiger implements WildCat
{
    @Override
    public String klichka()
    {
        return "белый тигр";
    }

    @Override
    public void growl()
    {
        System.out.println("rrrrrrrr");
    }

    @Override
    public void rip()
    {
        System.out.println("рву всех");
    }
}
