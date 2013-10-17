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

    private int placeInArray = 0;

    public char getNextChar()
    {
        String data = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEF" +
                "GHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        return data.charAt(placeInArray++);
    }
}