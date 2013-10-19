package edu.wcu.Chargen;

/**
 * The NonAlphaNumericCharacterSource class implements the
 * ChargenCharacterSource interface and produces a non-alphanumeric character
 * sequence produced by chargen servers.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NonAlphaNumericCharacterSource implements ChargenCharacterSource {

    /** The index of the array of chars. */
    int placeInArray = 0;

    /** An array of chars containing only non-alphanumerics. */
    String data = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    /**
     * Gets the next char from data and returns it.
     * @return - A char from the current index of data.
     */
    public char getNextChar()
    {
        if (placeInArray == data.length())
        {
            placeInArray = 0;
        }
        return data.charAt(placeInArray++);
    }

}
