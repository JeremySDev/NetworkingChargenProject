package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class AlphaNumericCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 62)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 61) && !(placeInArray < 0))
        {
            String data =
                    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                            "abcdefghijklmnopqrstuvwxyz";
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }
}
