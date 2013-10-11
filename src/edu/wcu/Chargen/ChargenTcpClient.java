package edu.wcu.Chargen;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * ChargenTcpClient is a class that extends AbstractChargenClient and provides
 * a concrete implementation of the printToStream() method using TCP.
 * Data received from the remote host is printed to the specified PrintStream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Haymans
 * @version 10/8/13.
 */
public class ChargenTcpClient extends AbstractChargenClient {

    /* make a socket on the client side */
    Socket clientSocket = null;
    /* make a socket on the server side based on the host and port */
    Socket serverSocket = null;

    /**
     * The constructor for ChargenTcpClient sets the host and port using
     * AbstractChargenClient's constructor
     *
     * @param host - the host's InetAddress.
     * @param port - the port number to use.
     */
    public ChargenTcpClient(InetAddress host, int port) {
        super(host, port);
    }

    /**
     *
     * @param out - a PrintStream object
     */
    public void printToStream(PrintStream out)
    {
        socketHelper();
        Scanner outputFromServer = null;
        try {
            outputFromServer = new Scanner(new InputStreamReader
                    (clientSocket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Problem connecting client and server: " + e);
            System.exit(1);
        }

        try {
            out = new PrintStream(outputFromServer.next());
        } catch (FileNotFoundException e) {
            System.err.println("Problem connecting client and server: " + e);
            System.exit(1);
        }

        System.out.println(out);
    }

    private void socketHelper()
    {
        try
        {
            /* make a socket on the client side */
            clientSocket = new Socket();

            /* make a socket on the server side based on the host and port */
            serverSocket = new Socket(this.getHost(), this.getPort());

            /* connect the two sockets */
            clientSocket.connect(serverSocket.getRemoteSocketAddress());

        }
        catch(IOException e)
        {
            System.err.println("Problem connecting client and server: " + e);
            System.exit(1);
        }
    }

}
