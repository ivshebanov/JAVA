package patterns.factory.cars;

import patterns.factory.parts.Engine;
import patterns.factory.parts.Paint;
import patterns.factory.parts.Wheels;

/**
 * Created by iliashebanov on 13.10.16.
 */
public abstract class Car
{
    protected String name = "";
    protected String body = "Caravan";

    protected Paint paintColor;
    protected Wheels wheels;
    protected Engine engine;


    public abstract void configure();

//        System.out.println("Configuring " + name);
//        System.out.println("Engin is: " + engine);
//        System.out.println("Body is: " + body);
//        System.out.println("PaintColor is: " + paintColor);
//        System.out.println("Wheels are: " + wheels);


    public void assembleBody(){
        System.out.println("Body is assembled");
    }
    public void installEngine(){
        System.out.println("Engine is in its place");
    }
    public void paint(){
        System.out.println("Car is painted");
    }
    public void installWhels(){
        System.out.println("Wheels are installed");
    }


}
