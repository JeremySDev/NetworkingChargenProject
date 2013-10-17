package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NonAlphaNumericCharacterSource implements ChargenCharacterSource {

    public char getNextChar()
    {
        char returnMe = 'f';

        for (int i = 0; i < 30; i++)
        {
            String data = "!#$%&'()*+,-./:;<=>?@[]^_^`{|}~";
            returnMe = data.charAt(i);
        }

        return returnMe;
    }

}
