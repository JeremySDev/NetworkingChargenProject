package edu.wcu.Chargen;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * ChargenUDPClient is a class that extends AbstractChargenClient and provides
 * a concrete implementation of the printToStream() method using UDP. Data
 * received from the remote host is printed to the specified PrintStream. Runs
 * on localHost (agora).
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenUdpClient extends AbstractChargenClient {

    /**
     * Time in milliseconds until timeout.
     */
    private static final int TIMEOUT = 5000;

    /**
     * The port number for the clientSocket.
     */
    private static final int LOCAL_PORT = 12345;

    /**
     * Client UDP socket.
     */
    private DatagramSocket clientSocket;

    /**
     * DatagramPacket to hold information to send to server.
     */
    private DatagramPacket packet;

    /**
     * The buffer array of bytes to send.
     */
    private byte[] buffer;

    /**
     * Constructor initializes fields to a given destination host address and
     * port number.
     *
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
     *
     * @param out - The PrintStream to carry the server's response.
     * @throws ChargenServerException - If the local host can't be resolved or
     *                                when creating a new DatagramSocket.
     */
    public void printToStream(PrintStream out) {
        /* call helper method to create the clientSocket */
        clientSocket = makeSocket(LOCAL_PORT);

        /* call helper method to create the packet */
        packet = makePacket(buffer, buffer.length, getHost(), getPort());

        /* call helper to send and receive data from server (communicate)*/
        /* received data is stored in buffer*/
        communicate(clientSocket, packet, buffer);

        /* print the data from the server using the out PrintStream */
        out.println(new String(packet.getData()));

        /* close the socket and stream */
        out.close();
        clientSocket.close();
    }

    /**
     * Helper method that creates and returns a new DatagramSocket using a given
     * port number and using the local host address.
     *
     * @param port - The given destination port number.
     * @return - A new DatagramSocket to be used to talk to the server.
     * @throws ChargenServerException - When creating a new DatagramSocket or if
     *                                local host can't be resolved.
     */
    private DatagramSocket makeSocket(int port) throws ChargenServerException {
        try {
            DatagramSocket newSocket;

            // create new socket
            newSocket = new DatagramSocket(port, InetAddress.getLocalHost());

            return newSocket;
        } catch (SocketException se) {
            throw new ChargenServerException(se);
        } catch (UnknownHostException uhe) {
            throw new ChargenServerException(uhe);
        }
    }

    /**
     * Helper method creates a new DatagramPacket to send between the client
     * and server during communication.
     *
     * @param buffer - An array of bytes to hold sent and received data.
     * @param length - The length of the buffer.
     * @param host   - The IP address of the remote host.
     * @param port   - The remote host's port number.
     * @return - A new DatagramPacket to use for communication.
     */
    private DatagramPacket makePacket(byte[] buffer, int length,
                                      InetAddress host, int port) {
        DatagramPacket packet;

        // create new packet
        packet = new DatagramPacket(buffer, length, host, port);
        return packet;
    }

    /**
     * Helper method that communicates between client and server. Sends a
     * DatagramPacket to a server and receives one in response.
     *
     * @param clientSocket - The socket used for client/server communications.
     * @param packet       - The packet to be exchanged.
     * @param buffer       - The buffer to hold received data.
     * @throws ChargenServerException - when the socket has timed out, when the
     *                                receiving socket has problems, or if
     *                                the client and server miscommunicate.
     */
    private void communicate(DatagramSocket clientSocket, DatagramPacket packet,
                             byte[] buffer) {
        try {
            // send a DatagramPacket to server
            clientSocket.send(packet);

            // set timeout time
            clientSocket.setSoTimeout(TIMEOUT);

            // receive a DatagramPacket from the server
            clientSocket.receive(packet);
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
