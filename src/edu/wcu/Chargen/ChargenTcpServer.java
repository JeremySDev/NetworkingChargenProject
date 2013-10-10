package edu.wcu.Chargen;
import edu.wcu.Chargen.ChargenCharacterSource;
import edu.wcu.Chargen.AbstractChargenServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenTcpServer is a class that extends AbstractChargenServer and provides
 * a concrete implementation of the listen() method using TCP. The method
 * repeatedly waits for a client to connect and responds appropriately.
 * This will be a serial server.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenTcpServer extends AbstractChargenServer {

    private static final int DEFAULT_PORT = 19;

    private int port;

    private ChargenCharacterSource source;

    public ChargenTcpServer()
    {
        this(DEFAULT_PORT, new DefactoChargenCharacterSource());
    }

    public ChargenTcpServer(int port)
    {
        this(port, new DefactoChargenCharacterSource());
    }

    public ChargenTcpServer(ChargenCharacterSource source)
    {
        this(DEFAULT_PORT, source);
    }

    public ChargenTcpServer(int port, ChargenCharacterSource source)
    {
        this.port = port;
        this.source = source;
    }

    @Override
    public void listen() throws IOException {
        try
        {
            ServerSocket serverSocket = new ServerSocket(this.port);
            Socket clientSocket = serverSocket.accept();
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("stuff");  // send serilized payload
            objectOutputStream.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Unable to read data from an open socket.");
            System.err.println(ioe.toString());
            System.exit(1);
        }
    }
}
