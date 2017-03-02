package patterns.factory.facilities;

import patterns.factory.cars.*;
import patterns.factory.partsFactory.CarPartsFactory;
import patterns.factory.partsFactory.DeutschCarPartsFactory;
/**
 * Created by iliashebanov on 13.10.16.
 */
public class DeutschVolkswagenFacility extends VolkswagenFacility
{
    @Override
    public Car createCar(String type)
    {
        Car car;
        CarPartsFactory factory = new DeutschCarPartsFactory();
        if (type.equals("Golf")) return new Golf(factory);
        else if (type.equals("Passat")) return new Passat(factory);
        else if (type.equals("Tiguan")) return new Tiguan(factory);
        else if (type.equals("Touareg")) return new Touareg(factory);
        return null;
    }
}
