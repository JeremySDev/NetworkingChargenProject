package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NumericCharacterSource implements ChargenCharacterSource {

    String data = "0123456789";

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
