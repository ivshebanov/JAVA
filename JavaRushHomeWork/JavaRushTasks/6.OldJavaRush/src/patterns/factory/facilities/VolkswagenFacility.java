package patterns.factory.facilities;

import patterns.factory.cars.*;

/**
 * Created by iliashebanov on 13.10.16.
 */
public abstract class VolkswagenFacility
{
    public Car getCar(String type){
        Car car = createCar(type);

        car.configure();
        car.assembleBody();
        car.installEngine();
        car.paint();
        car.installWhels();
        System.out.println("");

        return car;
    }
    public abstract Car createCar(String type);
}
