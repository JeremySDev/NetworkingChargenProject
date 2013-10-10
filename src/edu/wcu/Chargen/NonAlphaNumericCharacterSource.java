package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class NonAlphaNumericCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    private String data = "!#$%&'()*+,-./:;<=>?@[]^_^`{|}~";

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 30)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 29) && !(placeInArray < 0))
        {
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }

}
