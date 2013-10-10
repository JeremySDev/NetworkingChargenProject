package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * The DefactoChargenCharacterSource class implements the ChargenCharacterSource
 * interface and produces the defacto standard character sequence produced by
 * chargen servers. Used when the
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/9/13
 */
public class DefactoChargenCharacterSource implements ChargenCharacterSource {

    private int placeInArray = 0;

    String data = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    public char getNextChar()
    {
        return data.charAt(placeInArray++);
    }
}