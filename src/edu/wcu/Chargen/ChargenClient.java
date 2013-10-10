package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public interface ChargenClient {
    public void printToStream(PrintStream out);
}
