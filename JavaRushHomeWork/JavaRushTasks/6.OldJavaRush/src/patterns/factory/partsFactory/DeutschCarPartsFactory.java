package patterns.factory.partsFactory;

import patterns.factory.parts.*;

/**
 * Created by iliashebanov on 13.10.16.
 */
public class DeutschCarPartsFactory extends  CarPartsFactory
{
    @Override
    public Engine CreateEngine()
    {
        return new DieselEngine();
    }

    @Override
    public Paint CreatePaint()
    {
        return new WhitePaint();
    }

    @Override
    public Wheels CreateWheels()
    {
        return new BigWheels();
    }
}
