package edu.wcu.Chargen;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

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
     *
     * @param out
     */
    public void printToStream(PrintStream out)
    {
        try
        {
            Socket clientSocket = new Socket();
            Socket serverSocket = new Socket(this.getHost(), this.getPort());
        }
        catch(IOException e)
        {
            System.err.println("Problem connecting client and server: " + e);
            System.exit(1);
        }

    }

}
