package edu.wcu.Chargen;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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

    /**
     * The constructor for ChargenTcpClient sets the host and port using
     * AbstractChargenClient's constructor
     *
     * @param host - the host's InetAddress.
     * @param port - the port number to use.
     */
    public ChargenTcpClient(InetAddress host, int port)
    {
        super(host, port);
    }

    /**
     * printToStream - calls the methods that are necessary to get output from a
     * server.
     *
     * @param out - a PrintStream object
     * @throws java.io.IOException
     */
    public void printToStream(PrintStream out) throws IOException
    {
        /* Call the helper method */
        socketHelper();

        /* Create a Scanner to get the output of the Chargen server */
        Scanner outputFromServer = new Scanner(new InputStreamReader(
                clientSocket.getInputStream()));

        /* Print the output of the server to the screen */
        out.println(outputFromServer.next());

        /* close sockets and streams */
        out.close();
        clientSocket.close();
    }

    /**
     * socketHelper - helper method, called by printToStream, that does the work
     * of setting up a socket and connecting it to the server. It also check to
     * see if a flag is set so that it can send the server that flag.
     *
     * @throws IOException
     */
    private void socketHelper() throws IOException
    {
        /* make a socket on the client side */
        clientSocket = new Socket(this.getHost(), this.getPort());

        /* if statement to determine if we need to send a flag */
        if (this.getFlag() != null)
        {
            /* Set the flag to a Sting */
            String flag = this.getFlag();

            /* Create an print stream to send the flag to the server */
            PrintStream outToServer = new PrintStream(
                    clientSocket.getOutputStream());

            /* Send the flag to the Server */
            outToServer.print(flag + "\r\n");
            //outToServer.close();
        }
    }
}