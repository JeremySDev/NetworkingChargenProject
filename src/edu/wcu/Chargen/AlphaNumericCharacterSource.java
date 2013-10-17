package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class AlphaNumericCharacterSource implements ChargenCharacterSource {

    String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz";

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
