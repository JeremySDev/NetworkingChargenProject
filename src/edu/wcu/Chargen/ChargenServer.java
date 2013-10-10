package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenServer is the interface to a chargen server implementation. The
 * interface includes a method: listen(). Classes implementing this interface
 * will provide an implementation of this method.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13
 */
public interface ChargenServer {
    /* listen will listen for requests from clients. */
    public void listen();
}
