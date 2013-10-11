package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

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
        try {
            clientSocket = makeSocket(getPort());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // call helper method to create the packet
        try {
            packet = makePacket(buffer, buffer.length, getHost(), getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // call helper to send and receive data from server (communicate)
        // received data is stored in buffer
        communicate(clientSocket, packet, buffer);

        // print the data from the server using the out PrintStream
        // TODO:

        // call helper method to close the socket and stream
        close(clientSocket);
    }

    /**
     * Helper method that creates and returns a new DatagramSocket using a given
     * port number and using the local host address.
     *
     * @param port - The given destination port number.
     * @return - A new DatagramSocket to be used to talk to the server.
     * @throws SocketException - when creating a new DatagramSocket.
     * @throws UnknownHostException - if local host can't be resolved into an
     * address.
     */
    private DatagramSocket makeSocket(int port) throws SocketException,
            UnknownHostException
    {
        DatagramSocket newSocket = null;

        // create new socket
        newSocket = new DatagramSocket(port, InetAddress.getLocalHost());

        return newSocket;
    }

    /**
     * Helper method creates a new DatagramPacket to send between the client
     * and server during communication.
     *
     * @param buffer - An array of bytes to hold sent and received data.
     * @param length - The length of the buffer.
     * @param host - The IP address of the remote host.
     * @param port - The remote host's port number.
     * @return - A new DatagramPacket to use for communication.
     * @throws UnknownHostException - if invalid information is given to the
     * packet.
     */
    private DatagramPacket makePacket(byte[] buffer, int length,
                                      InetAddress host, int port)
            throws UnknownHostException
    {
        DatagramPacket packet = null;

        // create new packet
        packet = new DatagramPacket(buffer, length, host, port);
        return packet;
    }

    /* TODO: */
    private void communicate(DatagramSocket clientSocket, DatagramPacket packet,
                             byte[] buffer)
    {

    }

    /* TODO: */
    private void close(DatagramSocket clientSocket)
    {

    }
}
