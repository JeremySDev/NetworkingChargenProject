package edu.wcu.Chargen;

/**
 * The DefactoChargenCharacterSource class implements the ChargenCharacterSource
 * interface and produces the defacto standard character sequence produced by
 * chargen servers.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/9/13
 */
public class DefactoChargenCharacterSource implements ChargenCharacterSource {

    /** The index of the array of chars. */
    private int placeInArray = 0;

    /** An array of chars containing all possible chars. */
    private final String data = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEF" +
            "GHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";

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