package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenClientDriver is the entry point of the application. It includes one
 * method: main(). The program accepts either two, three, or four parameters.
 * The first parameter must be the string “TCP” or the string “UDP” (case does
 * not matter). The program will use this parameter to determine which client
 * implementation to use. The second parameter must be the IP address or
 * hostname of the server to which to connect. The third, optional, parameter is
 * the port number to which to connect. If this parameter is not supplied, the
 * default value will be 19 (the “well-known” chargen port). The fourth,
 * optional, parameter is a flag to send to the version of the Chargen server.
 * The flags are defined in the RFC listed on the main web page. In the absence
 * of any flag, the client and server use default behaviors.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenClientDriver {
    public static void main(String[] args)
    {

    }
}
