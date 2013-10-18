package edu.wcu.Chargen;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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

    private final int port;

    private final ChargenCharacterSource source;

    public ChargenTcpServer ()
    {
        this(DEFAULT_PORT, new DefactoChargenCharacterSource());
    }

    public ChargenTcpServer (int port)
    {
        this(port, new DefactoChargenCharacterSource());
    }

    public ChargenTcpServer (ChargenCharacterSource source)
    {
        this(DEFAULT_PORT, source);
    }

    public ChargenTcpServer (int port, ChargenCharacterSource source)
    {
        this.port = port;
        this.source = source;
    }

    /**
     *
     */
    @Override
    public void listen ()
    {
        String flag = "cats";
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        Scanner inFromClient = null;
        PrintStream outToClient = null;

        try
        {
            /* Make a connection to a client socket */
            serverSocket = new ServerSocket(this.port);

            /* Connect to a client socket */
            clientSocket = serverSocket.accept();

            /* Create a scanner to catch the flag input of the client */
            inFromClient = new Scanner(new InputStreamReader(
                    clientSocket.getInputStream()));

            /* Create a print stream from the client socket to send the chars */
            outToClient = new PrintStream(clientSocket.getOutputStream());

            /* get the flag from the client */
            flag = inFromClient.next();

            flagHelper(flag);
            while (!clientSocket.isOutputShutdown())
            {
                outToClient.println(this.getCharacterSource().getNextChar());
                System.out.println("in the while");
            }
            System.out.println("hello");

            //inFromClient.close();
            //outToClient.close();
            //clientSocket.close();
            //serverSocket.close();
            listen();
        }
        catch (IOException ioe) {
            System.err.println("Unable to read data from an open socket.");
            System.err.println(ioe.toString());
            //System.exit(1);
        }
        finally
        {
            inFromClient.close();
            outToClient.close();
            try {
                clientSocket.close();
                serverSocket.close();
            }
            catch (IOException e) {
                System.err.println("Unable to read data from an open socket.");
                System.err.println(e.toString());
                //System.exit(1);
            }
        }
        System.out.println("Flag: " + flag);
    }

    /**
     * @param flag
     */
    private void flagHelper (String flag)
    {
        System.out.println("Flag: " + flag);
        switch (flag) {
            case "NAN":
                this.changeSource(new NonAlphaNumericCharacterSource());
                break;
            case "AN":
                this.changeSource(new AlphaNumericCharacterSource());
                break;
            case "N":
                this.changeSource(new NumericCharacterSource());
                break;
            default:
                this.changeSource(new DefactoChargenCharacterSource());
                break;
        }
    }
}