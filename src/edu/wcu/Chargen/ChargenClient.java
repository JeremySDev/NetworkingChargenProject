package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenClient is the interface to a chargen client implementation. The
 * interface includes one method: printToStream() which takes a PrintStream as
 * a parameter. Classes implementing this interface will provide an
 * implementation of this method that prints the received character sequence to
 * the supplied stream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public interface ChargenClient {
    public void printToStream(PrintStream out);
}