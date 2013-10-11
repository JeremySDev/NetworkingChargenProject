package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ChargenUDPClient is a class that extends AbstractChargenClient and provides
 * a concrete implementation of the printToStream() method using UDP. Data
 * received from the remote host is printed to the specified PrintStream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenUdpClient extends AbstractChargenClient {

    /** Client UDP socket. */
    private DatagramSocket clientSocket;

    /** DatagramPacket to hold information to send to server. */
    private DatagramPacket packet;

    /** The buffer array of bytes to send. */
    private byte[] buffer;

    /**
     * Constructor initializes fields to a given destination host address and
     * port number.
     * @param host - The destination host's IP address.
     * @param port - The destination host's port number.
     */
    public ChargenUdpClient(InetAddress host, int port) {
        super(host, port);
        clientSocket = null;
        packet = null;
        buffer = new byte[256];
    }

    /**
     * Initiates communications with the UDP server via PrintStream.
     * Data received from the remote host is printed to the specified
     * PrintStream.
     * @param out - The PrintStream to carry the server's response.
     */
    public void printToStream(PrintStream out)
    {
        //TODO: Do legit client things and use helper methods
        // Utilize super.printToStream?
        //use getHost() and getPort();

        // call helper method to create the clientSocket
        makeSocket(getPort());

        // call helper method to create the packet
        makePacket(buffer, buffer.length, getHost(), getPort());

        // call helper to send and receive data from server (communicate)
        communicate(clientSocket, packet, buffer);

        // print the data from the server using the out PrintStream


        // call helper method to close the socket and stream
        // TODO:
    }
}
