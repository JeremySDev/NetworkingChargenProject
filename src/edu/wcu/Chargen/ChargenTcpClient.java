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
        try
        {
        Socket clientSocket = new Socket();
        Socket serverSocket = new Socket(this.host, this.port);
        }
        catch(IOException e)
        {
            System.err.println("Problems Creating Sockets: " + e);
            System.exit(1);
        }
        /* Try to connect to the server socket on polaris */
        try
        {
            /* Connect the client and server socket */
            clientSocket.connect(serverSocket.getRemoteSocketAddress());
        }
        catch(IOException e)
        {
            System.err.println("Problem connecting client and server: " + e);
            System.exit(1);
        }

    }

}
