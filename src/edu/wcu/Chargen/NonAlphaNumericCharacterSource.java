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

    private char[] data = {
            '!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.',
            '/', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '`'};

    public char getNextChar()
    {
        return data[placeInArray++];
    }

}
