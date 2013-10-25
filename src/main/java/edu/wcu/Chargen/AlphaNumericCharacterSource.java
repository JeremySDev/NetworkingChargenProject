package edu.wcu.Chargen;

/**
 * The AlphaNumericCharacterSource class implements the ChargenCharacterSource
 * interface and produces an alphanumeric character sequence produced by
 * chargen servers.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class AlphaNumericCharacterSource implements ChargenCharacterSource {

    /** The index of the array of chars. */
    private int placeInArray = 0;

    /** An array of chars containing only alphanumerics. */
    private String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz";

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
