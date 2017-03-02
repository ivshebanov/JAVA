package patterns.factory.partsFactory;

import patterns.factory.parts.Engine;
import patterns.factory.parts.Paint;
import patterns.factory.parts.Wheels;

/**
 * Created by iliashebanov on 13.10.16.
 */
public abstract class CarPartsFactory
{
    public abstract Engine CreateEngine();
    public abstract Paint CreatePaint();
    public abstract Wheels CreateWheels();
}
