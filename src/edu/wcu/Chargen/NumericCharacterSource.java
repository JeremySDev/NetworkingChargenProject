package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NumericCharacterSource implements ChargenCharacterSource {
    private int placeInArray = 0;

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 10)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 9) && !(placeInArray < 0))
        {
            String data = "0123456789";
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }
}
