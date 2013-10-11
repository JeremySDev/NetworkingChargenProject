package edu.wcu.Chargen;

/**
 * The DefactoChargenCharacterSource class implements the ChargenCharacterSource
 * interface and produces the defacto standard character sequence produced by
 * chargen servers. Used when the
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/9/13
 */
public class DefactoChargenCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    private final String data = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEF" +
            "GHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    public char getNextChar()
    {
        return data.charAt(placeInArray++);
    }
}