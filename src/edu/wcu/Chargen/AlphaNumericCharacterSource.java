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
public class AlphaNumericCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    private String data =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 62)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 61) && !(placeInArray < 0)
        {
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }
}
