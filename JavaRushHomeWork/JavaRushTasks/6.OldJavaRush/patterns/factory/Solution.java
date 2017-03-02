package patterns.factory;

import patterns.factory.facilities.DeutschVolkswagenFacility;
import patterns.factory.facilities.RussianVolkswagenFacility;
import patterns.factory.facilities.VolkswagenFacility;

/**
 * Created by iliashebanov on 13.10.16.
 */
public class Solution
{
    public static void main(String[] args)
    {
        VolkswagenFacility volkswagenFacility = new DeutschVolkswagenFacility();
        volkswagenFacility.getCar("Golf");
        volkswagenFacility.getCar("Passat");
        volkswagenFacility.getCar("Tiguan");
        volkswagenFacility.getCar("Touareg");

        VolkswagenFacility volkswagenFacility1 = new RussianVolkswagenFacility();
        volkswagenFacility1.getCar("Golf");
        volkswagenFacility1.getCar("Passat");
        volkswagenFacility1.getCar("Tiguan");
        volkswagenFacility1.getCar("Touareg");
    }
}
