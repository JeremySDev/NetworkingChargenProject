package edu.wcu.Chargen;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    /* make a socket on the server side based on the host and port */
    Socket serverSocket = null;
    int num = 1;
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
     * @param out - a PrintStream object
     */
    public void printToStream(PrintStream out) throws IOException {
        socketHelper();
        Scanner outputFromServer = new Scanner(new InputStreamReader(
                clientSocket.getInputStream()));
        out.print(outputFromServer.next());
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    private void socketHelper() throws IOException {
        /* make a socket on the client side */
        clientSocket = new Socket();
        System.out.println("Made Client Socket");

        /* make a socket on the server side based on the host and port */
        serverSocket = new Socket(this.getHost(), this.getPort());
        System.out.println("Made Server Socket");
        System.out.println("Host: " + this.getHost());

        /* connect the two sockets */
        clientSocket.connect(serverSocket.getRemoteSocketAddress());
        System.out.println("Connected Client and Server");

        System.out.println("Flag: " + this.getFlag());
        /*if (!((this.getFlag()).equals(null))) {*/
        String flag = this.getFlag();
        System.out.println("Set Flag");

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Made buffered reader");

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("Made Data Output Stream");

        outToServer.writeBytes(flag + '\n');
        System.out.println("Wrote Bytes");
        /*}*/
    }
}