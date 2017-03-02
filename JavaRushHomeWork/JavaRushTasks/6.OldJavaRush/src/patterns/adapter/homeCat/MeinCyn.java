package patterns.adapter.homeCat;

/**
 * Created by iliashebanov on 03.10.16.
 */
public class MeinCyn implements HomeCat
{
    @Override
    public String name()
    {
        return "MeinCyn";
    }

    @Override
    public void mew()
    {
        System.out.println("mew mew");
    }

    @Override
    public void scratch()
    {
        System.out.println("Не царапаюсь");
    }
}
