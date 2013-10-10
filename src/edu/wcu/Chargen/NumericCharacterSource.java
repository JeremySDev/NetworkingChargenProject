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

    private char[] data = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public char getNextChar()
    {
        return data[placeInArray++];
    }
}
