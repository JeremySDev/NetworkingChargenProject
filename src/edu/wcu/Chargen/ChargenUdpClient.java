package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenTcpClient is a class that extends AbstractChargenClient and provides a
 * concrete implementation of the printToStream() method using UDP. Data
 * received from the remote host is printed to the specified PrintStream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenUdpClient extends AbstractChargenClient {
    public void printToStream(PrintStream out)
    {

    }
}
