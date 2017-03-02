package patterns.adapter.homeCat;

/**
 * Created by iliashebanov on 03.10.16.
 */
public class Syamskyi implements HomeCat
{
    @Override
    public String name()
    {
        return "Syamskyi";
    }

    @Override
    public void mew()
    {
        System.out.println("мурлакаю");
    }

    @Override
    public void scratch()
    {
        System.out.println("Люблю царапать");
    }
}
