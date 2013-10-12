package edu.wcu.Chargen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

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

    /** The default port number for Chargen protocol. */
    private static final int DEFAULT_PORT = 19;

    /** The port number for this server. */
    private int serverPort;

    /** The socket for this server to use. */
    private DatagramSocket serverSocket;

    /** Array of bytes to hold data to receive from client. */
    byte[] receiveData;

    /** Array of bytes to hold data to send to client. */
    byte[] sendData;

    /**
     * Determines whether to generate AlphaNumeric, NonAlphaNumeric, Numeric, or
     * Defacto characters.
     */
    ChargenCharacterSource typeChars;

    /**
     * Default constructor that creates a new server with default port and char
     * generation type.
     * throws IOException - if an I/O error occurs when opening the socket.
     */
    public ChargenUdpServer() throws IOException
    {
        this(DEFAULT_PORT, new DefactoChargenCharacterSource());
    }

    /**
     * Constructor that takes a port number and creates a socket based on it.
     * @param port - A given port number for this server.
     * @throws IOException - if an I/O error occurs when opening the socket.
     */
    public ChargenUdpServer(int port) throws IOException
    {
        this(port, new DefactoChargenCharacterSource());
    }

    /**
     * Constructor that takes a ChargenCharacterSource and creates a socket with
     * default values.
     * @param source - A ChargenCharacterSource determining which types of chars
     *                 to generate.
     * @throws IOException - if an I/O error occurs when opening the socket.
     */
    public ChargenUdpServer(ChargenCharacterSource source) throws IOException
    {
        this(DEFAULT_PORT, source);
    }

    /**
     * Constructor that takes a port and a ChargenCharacterSource. It creates a
     * socket based on the port number and determines which types of chars to
     * generate based on the source given.
     * @param port - A given port number for the server.
     * @param source - A ChargenCharacterSource determining which types of chars
     *                 to generate.
     * @throws IOException - if an I/O error occurs when opening the socket.
     */
    public ChargenUdpServer(int port, ChargenCharacterSource source) throws
            IOException
    {
        serverPort = port;
        typeChars = source;
        sendData = new byte[256];
        receiveData = new byte[256];
        serverSocket = new DatagramSocket(serverPort);
    }

    /**
     * This method listens for UDP datagrams on UDP port 19.  When a datagram is
     * received, an answering datagram is sent containing a random number
     * (between 0 and 512) of characters (the data in the received datagram is
     * ignored). There is no history or state information associated with the
     * UDP version of this service, so there is no continuity of data from one
     * answering datagram to another.
     *
     * The service only send one datagram in response to each received
     * datagram, so there is no concern about the service sending data faster
     * than the user can process it.
     * @throws IOException - if there are problems closing a socket.
     */
    public void listen() throws IOException
    {
        // TODO: Probably should use a helper! Too long!

        // Packet to receive client's data
        DatagramPacket receievePacket = new DatagramPacket(receiveData,
                                                           receiveData.length);

        // Packet to hold server's data
        DatagramPacket sendPacket = null;

        // Generated sequence of chars
        String charSequence = "";

        // random number generated
        int randomNum = 0;

        // Random number generator
        Random random = new Random();

        // TODO: Needs to stop at some time
        // wait to receive a datagram
        while (true)
        {
            // receive a packet from the client
            serverSocket.receive(receievePacket);

            // TODO: works?
            if (receievePacket.getData() != null)
            {
                // generate a random number from 0 to 512
                randomNum = random.nextInt(513);

                // generate an appropriate char sequence (for loop) use getNext
                for (int i = 0; i < randomNum; i++)
                {
                    charSequence = charSequence +
                                   String.valueOf(typeChars.getNextChar());
                }

                // put the char sequence into the sending byte array
                sendData = charSequence.getBytes();

                // send this sequence to the client
                sendPacket = new DatagramPacket(sendData, sendData.length,
                        receievePacket.getAddress(), receievePacket.getPort());
                serverSocket.send(sendPacket);
            }
        }

        // close the socket after done listening... here?
        // TODO: serverSocket.close();
    }
}
