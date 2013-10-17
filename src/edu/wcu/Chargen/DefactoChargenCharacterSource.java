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

    String data = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEF" +
            "GHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    public char getNextChar()
    {
        char character = 'f';
        for (int i = 0; i < data.length(); i++)
        {
            character = data.charAt(i);
        }
        return character;
    }
}