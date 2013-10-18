package edu.wcu.Chargen;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    public void listen() {
        String flag = "cats";
        try
        {
            /* Make a connection to a client socket */
            ServerSocket serverSocket = new ServerSocket(this.port);
            Socket clientSocket = serverSocket.accept();

            Scanner inFromClient = new Scanner(new InputStreamReader(clientSocket.getInputStream()));

            PrintStream outToClient = new PrintStream(clientSocket.getOutputStream());

            System.out.println("Flag: " + flag);
            flag = inFromClient.next();
            System.out.println("Flag: " + flag);
            /*switch (flag) {
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
            }*/
            flagHelper(flag);
            System.out.println("Called Flag helper");

            //while ((this.getCharacterSource().getNextChar()) != '\0')
            //{
                outToClient.println((this.getCharacterSource()).getNextChar());
            //}
        }
        catch (IOException ioe)
        {
            System.err.println("Unable to read data from an open socket.");
            System.err.println(ioe.toString());
            System.exit(1);
        }
        System.out.println("Flag: " + flag);
    }

    private void flagHelper(String flag)
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