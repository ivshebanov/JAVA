package patterns.factory.partsFactory;

import patterns.factory.parts.*;

/**
 * Created by iliashebanov on 13.10.16.
 */
public class RussianCarPartsFactory extends CarPartsFactory
{
    @Override
    public Engine CreateEngine()
    {
        return new GasolineEngine();
    }

    @Override
    public Paint CreatePaint()
    {
        return new BlackPaint();
    }

    @Override
    public Wheels CreateWheels()
    {
        return new MediumWheels();
    }
}
