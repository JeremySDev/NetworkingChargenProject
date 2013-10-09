package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenUdpServer is a class that extends AbstractChargenServer and provides a
 * concrete implementation of the listen() method using UDP. The method
 * repeatedly waits for a datagram from a client and responds appropriately.
 * This will be a serial server.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenUdpServer extends AbstractChargenServer {

    public ChargenUdpServer()
    {

    }

    public ChargenUdpServer(int port)
    {

    }

    public ChargenUdpServer(ChargenCharacterSource source)
    {

    }

    public ChargenUdpServer(int port, ChargenCharacterSource source)
    {

    }

    public void listen()
    {

    }
}
