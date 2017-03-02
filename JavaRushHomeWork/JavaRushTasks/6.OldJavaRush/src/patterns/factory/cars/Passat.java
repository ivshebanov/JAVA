package patterns.factory.cars;

import patterns.factory.partsFactory.CarPartsFactory;

/**
 * Created by iliashebanov on 13.10.16.
 */
public class Passat extends Car
{
    private CarPartsFactory factory;
    public Passat(CarPartsFactory factory){
        this.factory = factory;
        name = "Passat";
        body = "Sedan";
    }

    @Override
    public void configure()
    {
        System.out.println("Configuring " + name);
        System.out.println("Body is: " + body);

        factory.CreateEngine();
        factory.CreatePaint();
        factory.CreateWheels();
    }
}
