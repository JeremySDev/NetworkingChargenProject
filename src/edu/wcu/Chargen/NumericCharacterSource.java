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
public class NumericCharacterSource implements ChargenCharacterSource {
    private int placeInArray = 0;

    private String data = "0123456789";

    public char getNextChar()
    {
        char returnMe = 'f';

        if (placeInArray == 10)
        {
            placeInArray = 0;
        }

        if (!(placeInArray > 9) && !(placeInArray < 0)
        {
            returnMe = data.charAt(placeInArray++);
        }

        return returnMe;
    }
}
