package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.InetAddress;

/**
 * ChargenTcpClient is a class that extends AbstractChargenClient and provides
 * a concrete implementation of the printToStream() method using TCP.
 * Data received from the remote host is printed to the specified PrintStream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenTcpClient extends AbstractChargenClient {

    public ChargenTcpClient(InetAddress host, int port) {
        super(host, port);
    }

    public void printToStream(PrintStream out)
    {

    }

}
