package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NonAlphaNumericCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 30)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 29) && !(placeInArray < 0))
        {
            String data = "!#$%&'()*+,-./:;<=>?@[]^_^`{|}~";
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }

}
